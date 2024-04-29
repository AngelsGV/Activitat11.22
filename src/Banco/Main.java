package Banco;
//Crea una aplicación que gestione los empleados
// de un banco (añadir, eliminar, mostrar, modificar).
// Para ello se definirá la clase Empleado con los
// atributos dni, nombre y sueldo.
// Los empleados se guardarán en un objeto de la clase
// Lista para objetos de la clase Object y en el
// fichero empleados.dat.
// La aplicación cargará en memoria, al arrancar,
// la lista de empleados desde el archivo empleados.dat

public class Main {
    public static void main(String[] args) {

        Metodos gestorEmpleados = new Metodos();

        // Cargar empleados desde el archivo
        gestorEmpleados.cargarEmpleados();

        // Agregar empleados
        gestorEmpleados.agregarEmpleado(new Empleado("12345678A", "Juan", 2000));
        gestorEmpleados.agregarEmpleado(new Empleado("98765432B", "María", 2500));

        // Mostrar empleados
        gestorEmpleados.mostrarEmpleados();

        // Guardar empleados en el archivo
        gestorEmpleados.guardarEmpleados();
    }
}
