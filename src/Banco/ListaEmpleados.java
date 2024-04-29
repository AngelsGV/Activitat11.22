package Banco;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListaEmpleados implements Serializable {
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
