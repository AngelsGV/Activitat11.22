package Banco;

import java.io.Serializable;

class Empleado implements Serializable {
    String dni;
    String nombre;
    double sueldo;

public Empleado(String dni,String nombre, double sueldo){
    this.dni = dni;
    this.nombre = nombre;
    this.sueldo = sueldo;
}
@Override
    public String toString(){
    return "dni: " + dni + ", nombre: " + nombre + ", dueldo: " + sueldo;
}
//Hasta aquí ok. Crear clase empleado.
}
