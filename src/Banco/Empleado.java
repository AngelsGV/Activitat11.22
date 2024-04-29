package Banco;

import java.io.*;

public class Empleado implements Serializable {//Ex resuelto 11.9
    private String dni;
    private String nombre;
    private double sueldo;

    public Empleado(String dni, String nombre, double sueldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }
    //Getters i setter necesaris

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "dni: '" + dni + ", nombre: '" + nombre + ", sueldo: " + sueldo;
    }
}

