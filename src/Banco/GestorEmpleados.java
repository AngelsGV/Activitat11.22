package Banco;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorEmpleados {
    private List<Empleado> empleados;
    private static final String NOMBRE_ARCHIVO = "empleados.dat";

    public GestorEmpleados() {
        empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void eliminarEmpleado(String dni) {
        empleados.removeIf(e -> e.getDni().equals(dni));
    }

    public void mostrarEmpleados() {
        empleados.forEach(System.out::println);
    }

    public void guardarEmpleados() {
        try (ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO))) {
            flujoSalida.writeObject(empleados);
            System.out.println("Empleados guardados correctamente en " + NOMBRE_ARCHIVO);
        } catch (IOException e) {
            System.err.println("Error al guardar empleados: " + e.getMessage());
        }
    }

    public void cargarEmpleados() {
        try (ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream(NOMBRE_ARCHIVO))) {
            empleados = (List<Empleado>) flujoEntrada.readObject();
            System.out.println("Empleados cargados correctamente desde " + NOMBRE_ARCHIVO);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar empleados: " + e.getMessage());
        }
    }
}
