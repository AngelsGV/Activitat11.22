package Banco;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListaEmpleados implements Serializable {//Después de crear la clase Empleado creí que esta sería igual
    //Se implementa seriabilizable para convertir los bytes en algo entendible
    private List<Empleado> empleados;//El enunciado pide List

    public ListaEmpleados() {
        this.empleados = new ArrayList<Empleado>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void eliminarEmpleado(int indice) {
        empleados.remove(indice);
    }

    public void mostrarEmpleados() {
        System.out.println("Lista de empleados:");
        for (int i = 0; i < empleados.size(); i++) {//recorremos toda la lista de empleados hasta completar su tamaño
            System.out.println(i + ": " + empleados.get(i));
        }
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
}
