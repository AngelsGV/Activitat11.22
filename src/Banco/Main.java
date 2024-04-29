package Banco;

public class Main {
    public static void main(String[] args) {

        GestorEmpleados gestorEmpleados = new GestorEmpleados();

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
