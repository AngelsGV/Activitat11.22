package Banco;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ListaEmpleados listaEmpleados = cargarEmpleado();
        if (listaEmpleados == null) {//para crearla si no está
            listaEmpleados = new ListaEmpleados();
        }
//switch per triar entre les opcions
        Scanner sc = new Scanner(System.in);//introduir datos teclat
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Añadir empleado");
            System.out.println("2. Eliminar empleado");
            System.out.println("3. Mostrar empleados");
            System.out.println("4. Modificar empleado");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();  // Consumir el salto de línea después del número

            switch (opcion) {
                case 1:
                    agregarEmpleado(sc, listaEmpleados);
                    break;
                case 2:
                    eliminarEmpleado(sc, listaEmpleados);
                    break;
                case 3:
                    listaEmpleados.mostrarEmpleados();
                    break;
                case 4:
                    modificarEmpleado(sc, listaEmpleados);
                    break;
                case 5:
                    guardarEmpleado(listaEmpleados);
                    System.out.println("Saliendo.");
                    return;
                default:
                    System.out.println("Inténtalo de nuevo.");
            }
        }
    }

    private static ListaEmpleados cargarEmpleado() {
        //busacremos el archivo y si no lo encontramos, creamos uno con el mismo nombre

        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("empleados.dat"))) {
            return (ListaEmpleados) entrada.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo. Se creará uno nuevo.");

        } catch (Exception  ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    private static void guardarEmpleado(ListaEmpleados listaEmpleados) {//se guarda en el fichero que toca

        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("empleados.dat"))) {
            salida.writeObject(listaEmpleados);
            System.out.println("Empleados guardados correctamente en el archivo.");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void agregarEmpleado(Scanner sc, ListaEmpleados listaEmpleados) {
//lo he tenido que modificar con scanner en todos sitios porque no me aclaraba en como ponerlo.

        System.out.print("DNI del empleado: ");
        String dni = sc.nextLine();
        System.out.print("Nombre del empleado: ");
        String nombre = sc.nextLine();
        System.out.print("Sueldo del empleado: ");
        double sueldo = sc.nextDouble();

        Empleado empleado = new Empleado(dni, nombre, sueldo);
        listaEmpleados.agregarEmpleado(empleado);
        System.out.println("Empleado añadido correctamente.");
    }

    private static void eliminarEmpleado(Scanner sc, ListaEmpleados listaEmpleados) {
        System.out.print("Ingrese el índice del empleado que quiere eliminar: ");
        int indice = sc.nextInt();
        sc.nextLine();  // Consumir el salto de línea después del número

        listaEmpleados.eliminarEmpleado(indice);
        System.out.println("Empleado eliminado correctamente.");
    }

    private static void modificarEmpleado(Scanner sc, ListaEmpleados listaEmpleados) {

        System.out.print("Ingrese el índice del empleado(se puede ver en la opción mostrar): ");
        int indice = sc.nextInt();

//problemas: no me dejaba introducir todos los datos modificados, solo de dos en dos.-->OK
        Empleado empleado = listaEmpleados.getEmpleados().get(indice);

        System.out.println("Empleado actual: " + empleado);

sc.nextLine();//sin esto me da problemas. pero no sé porque. Al final es solo un salto de pagina, no?

        System.out.println("Ingrese el nuevo DNI del empleado: ");
        String nuevoDni = sc.nextLine();
        empleado.setDni(nuevoDni);
        //para poder modificarlo desde la clase empleado el atributo que toca

        System.out.println("Ingrese el nuevo nombre del empleado: ");
        String nuevoNombre = sc.nextLine();
        empleado.setNombre(nuevoNombre);

        System.out.println("Ingrese el nuevo sueldo del empleado: ");
        double nuevoSueldo = sc.nextDouble();
        empleado.setSueldo(nuevoSueldo);
        sc.nextLine();  // Consumir el salto de línea después del número

        listaEmpleados.getEmpleados().set(indice, empleado); //sino no se guarda

        System.out.println("Empleado modificado correctamente.");
    }
}