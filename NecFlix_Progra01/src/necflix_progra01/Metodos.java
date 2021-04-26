/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package necflix_progra01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mmata
 */
public class Metodos {
    //Estas Varibles solo corresponde hazta ahorita al Cliente....
    Cliente_Peliculas[] listaClientesPeliculas = new Cliente_Peliculas[5];
    private int arregloConta = 0; // Contador de objetos creados. Variable muy importante.

    public void Consultar(String nombre, String direccion, int edad) {
        for (int i = 0; i < this.arregloConta; i++) {

            if (nombre.equals(this.listaClientesPeliculas[i].getNombre())) {
                System.out.println("Ya existe un EL Cliente con ese nombre");
            }
        }

    }

    public void Anadir(String nombre, String direccion, int edad) {
        if (arregloConta < 5) {
            this.listaClientesPeliculas[arregloConta] = new Cliente_Peliculas();
            this.listaClientesPeliculas[arregloConta].set_nombre(nombre);
            this.listaClientesPeliculas[arregloConta].set_direccion(direccion);
            this.listaClientesPeliculas[arregloConta].set_edad(edad);
            this.arregloConta++;
        } else {
            System.out.println("El ARREGLO ESTA COMPLETO");
        }

    }

    public void Buscar(String nombre) {
        boolean encontrado = false;

        for (int i = 0; i < arregloConta; i++) {
            if (nombre.equals(this.listaClientesPeliculas[i].getNombre())) {
                System.out.println(this.listaClientesPeliculas[i].getNombre() + " - " + " Direccion: " + this.listaClientesPeliculas[i].getDireccion() + " - " + " Edad: " + this.listaClientesPeliculas[i].getEdad());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Cliente no se encuentra en el arreglo..");
        }
    }

    public void Mostrar() {
        if (this.arregloConta == 0) {
            System.out.println("No hay Clientes");
        } else {
            for (int t = 0; t < this.arregloConta; t++) {
                // Es necesario por precaución usar el this para el metodo, puesto que si se ejecuta muchas veces la referencias a memoria pueden fallar.
                System.out.println(this.listaClientesPeliculas[t].getNombre() + " - " + " Direccion: " + this.listaClientesPeliculas[t].getDireccion() + " - " + " Edad: " + Integer.toString(this.listaClientesPeliculas[t].getEdad()));
            }
        }
    }

    public void Eliminar() {
        try {
            boolean encontrado = false;
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Nombre del Cliente a eliminar:");
            String eliminar = teclado.readLine().toUpperCase();
            if (arregloConta == 0) {
                System.out.println("No hay Clientes");
            } else {
                for (int i = 0; i < arregloConta; i++) {

                    if (eliminar.equals(this.listaClientesPeliculas[i].getNombre())) {
                        System.out.println(i + 1 + ". " + this.listaClientesPeliculas[i].getNombre() + " - " + " Direccion: " + this.listaClientesPeliculas[i].getDireccion() + " - " + " Edad: " + this.listaClientesPeliculas[i].getEdad());
                        encontrado = true;
                    }
                }
                if (encontrado) {
                    System.out.println("¿Qué Clientes quieres eliminar?, ¡INTRODUSCA LA EDAD DEL CLIENTE COMO REFERECIA!");
                    int eliminar_Clientes = Integer.parseInt(teclado.readLine());
                    eliminar_Clientes--;
                    System.out.println("¿Estas seguro (S/N)?");
                    String respuesta;
                    respuesta = teclado.readLine();
                    respuesta = respuesta.toUpperCase();
                    if (respuesta.equals("S")) {
                        Cliente_Peliculas[] temporal = new Cliente_Peliculas[5];
                        int ii = 0;
                        boolean encontrado2 = false;
                        for (int i = 0; i < this.arregloConta; i++) {

                            if (i != eliminar_Clientes) {
                                // Creo el objeto temporal para el borrado
                                if (!encontrado2) {
                                    temporal[ii] = this.listaClientesPeliculas[ii];
                                    ii++;
                                } else {
                                    if (ii < this.arregloConta) {
                                        temporal[ii] = this.listaClientesPeliculas[ii + 1];
                                        ii++;
                                    }
                                }

                            } else {
                                temporal[ii] = this.listaClientesPeliculas[ii + 1];
                                ii++;
                                encontrado2 = true;

                            }
                        }
                        this.arregloConta--;
                        System.out.println("Contacto eliminado correctamente");
                        for (int j = 0; j < this.arregloConta; j++) {
                            this.listaClientesPeliculas[j] = temporal[j];

                        }

                    }

                } else {
                    System.out.println("Lo siento, No se ha encontrado el nombre");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(NecFlix_Progra01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Modificar() {
        try {
            boolean encontrado = false;
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Nombre del Cliente a modificar:");
            String eliminar = teclado.readLine().toUpperCase();
            if (arregloConta == 0) {
                System.out.println("No hay Clientes");
            } else {
                for (int i = 0; i < this.arregloConta; i++) {

                    if (eliminar.equals(this.listaClientesPeliculas[i].getNombre())) {
                        System.out.println(i + 1 + ". " + this.listaClientesPeliculas[i].getNombre() + " - " + " Direccion: " + this.listaClientesPeliculas[i].getDireccion() + " - " + " Edad: " + this.listaClientesPeliculas[i].getEdad());
                        encontrado = true;
                    }
                }
                if (encontrado) {
                    System.out.println();
                    System.out.println("¿Qué Cliente quieres modificar?, ¡INTRODUSCA LA EDAD DEL CLIENTE COMO REFERECIA!");
                    int modificar_numero = Integer.parseInt(teclado.readLine());

                    System.out.println("Introduce nombre del cliente: ");
                    String nombre_nuevo = teclado.readLine();
                    System.out.println("Introduce direccion del Clente: ");
                    String direccion_nuevo = teclado.readLine();
                    System.out.println("Introduce la Edad, formato numerico:");
                    int edad_nuevo = Integer.parseInt(teclado.readLine());

                    this.listaClientesPeliculas[modificar_numero - 1].set_nombre(nombre_nuevo);
                    this.listaClientesPeliculas[modificar_numero - 1].set_direccion(direccion_nuevo);
                    this.listaClientesPeliculas[modificar_numero - 1].set_edad(edad_nuevo);

                } else {
                    System.out.println("No hay Clientes con ese nombre");
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(NecFlix_Progra01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
