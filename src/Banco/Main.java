package Banco;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static final String ARCHIVO_EMPLEADOS = "empleados.dat";

    public static void main(String[] args) {
        ListaEmpleados listaEmpleados = cargarEmpleadosDesdeArchivo();
        if (listaEmpleados == null) {
            listaEmpleados = new ListaEmpleados();
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Añadir empleado");
            System.out.println("2. Eliminar empleado");
            System.out.println("3. Mostrar empleados");
            System.out.println("4. Modificar empleado");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea después del número

            switch (opcion) {
                case 1:
                    agregarEmpleado(scanner, listaEmpleados);
                    break;
                case 2:
                    eliminarEmpleado(scanner, listaEmpleados);
                    break;
                case 3:
                    listaEmpleados.mostrarEmpleados();
                    break;
                case 4:
                    modificarEmpleado(scanner, listaEmpleados);
                    break;
                case 5:
                    guardarEmpleadosEnArchivo(listaEmpleados);
                    System.out.println("Saliendo.");
                    return;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        }
    }

    private static ListaEmpleados cargarEmpleadosDesdeArchivo() {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ARCHIVO_EMPLEADOS))) {
            return (ListaEmpleados) entrada.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de empleados. Se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar empleados desde el archivo: " + e.getMessage());
        }
        return null;
    }

    private static void guardarEmpleadosEnArchivo(ListaEmpleados listaEmpleados) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ARCHIVO_EMPLEADOS))) {
            salida.writeObject(listaEmpleados);
            System.out.println("Empleados guardados correctamente en el archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar empleados en el archivo: " + e.getMessage());
        }
    }

    private static void agregarEmpleado(Scanner scanner, ListaEmpleados listaEmpleados) {
        System.out.print("Ingrese el DNI del empleado: ");
        String dni = scanner.nextLine();
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el sueldo del empleado: ");
        double sueldo = scanner.nextDouble();
        scanner.nextLine();  // Consumir el salto de línea después del número

        Empleado empleado = new Empleado(dni, nombre, sueldo);
        listaEmpleados.agregarEmpleado(empleado);
        System.out.println("Empleado añadido correctamente.");
    }

    private static void eliminarEmpleado(Scanner scanner, ListaEmpleados listaEmpleados) {
        System.out.print("Ingrese el índice del empleado que desea eliminar: ");
        int indice = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea después del número

        listaEmpleados.eliminarEmpleado(indice);
        System.out.println("Empleado eliminado correctamente.");
    }

    private static void modificarEmpleado(Scanner scanner, ListaEmpleados listaEmpleados) {
        System.out.print("Ingrese el índice del empleado que desea modificar: ");
        int indice = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea después del número

        Empleado empleado = listaEmpleados.getEmpleados().get(indice);

        System.out.println("Empleado actual: " + empleado);

        System.out.print("Ingrese el nuevo DNI del empleado: ");
        String nuevoDni = scanner.nextLine();
        empleado.setDni(nuevoDni);

        System.out.print("Ingrese el nuevo nombre del empleado: ");
        String nuevoNombre = scanner.nextLine();
        empleado.setNombre(nuevoNombre);

        System.out.print("Ingrese el nuevo sueldo del empleado: ");
        double nuevoSueldo = scanner.nextDouble();
        empleado.setSueldo(nuevoSueldo);
        scanner.nextLine();  // Consumir el salto de línea después del número

        System.out.println("Empleado modificado correctamente.");
    }
}