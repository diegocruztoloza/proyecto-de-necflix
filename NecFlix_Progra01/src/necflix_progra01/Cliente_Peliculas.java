/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package necflix_progra01;

/**
 *
 * @author mmata
 */
public class Cliente_Peliculas {
    //Estas Varibles solo corresponde hazta ahorita al Cliente....
    //falata Agregar, inicializar, realizar los constructores (basio y declarado, set y get...
    private String nombre;
    private String direccion;
    private int edad;

    public Cliente_Peliculas() {
        this.nombre = null;
        this.direccion = null;
        this.edad = 0;
    }

    public Cliente_Peliculas(String nombre, String direccion, String edad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.edad = 0;
    }

    public void set_nombre(String nomb) {
        this.nombre = nomb.toUpperCase();
    }

    public void set_direccion(String direc) {
        this.direccion = direc;
    }

    public void set_edad(int eda) {
        this.edad = eda;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getEdad() {
        return edad;
    }
}
