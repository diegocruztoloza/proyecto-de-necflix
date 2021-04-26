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
public class NecFlix_Progra01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Estas Varibles solo corresponde hazta ahorita al Cliente....
        try {
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            String texto = "";
            char opcion = '1';
            Metodos ClientesPeliculas = new Metodos();
            while ((opcion == '1') || (opcion == '2') || (opcion == '3') || (opcion == '4') || (opcion == '5')) {
                System.out.println("_______________________");
                System.out.println("         NecFlis       ");
                System.out.println("_______________________");
                System.out.println("1-Nuevo Cliente");
                System.out.println("2-Buscar Cliente");
                System.out.println("3-Modificar Cliente");
                System.out.println("4-Eliminar Cliente");
                System.out.println("5-Listado de Cliente");
                System.out.println("0-Salir");
                System.out.println("_______________________");
                System.out.print("Seleccione una Opción: ");
                texto = teclado.readLine();
                opcion = texto.charAt(0);
                System.out.println("_______________________");

                switch (opcion) {
                    case '1':
                        String nombre;
                        String direccion;
                        String edad;
                        boolean validar;
                        System.out.println("Ingresa el Nombre del Cliente:");
                        nombre = teclado.readLine();
                        System.out.println("Ingresa la Direccion del Cliente:");
                        direccion = teclado.readLine();
                        System.out.println("Ingresa la Edad(numero) del Clente:");
                        edad = teclado.readLine();
                        validar = esNumerica(edad);
                        if (validar) {
                            int edad_entero = Integer.parseInt(edad);
                            ClientesPeliculas.Consultar(nombre, direccion, edad_entero);
                            ClientesPeliculas.Anadir(nombre, direccion, edad_entero);
                        } else {
                            System.out.println("No es un número, formato de Edad incorrecto.");
                        }

                        break;

                    case '2':
                        System.out.println("Cliente a buscar:");
                        nombre = teclado.readLine().toUpperCase();
                        ClientesPeliculas.Buscar(nombre);
                        break;
                    case '3':
                        ClientesPeliculas.Modificar();
                        break;
                    case '4':
                        ClientesPeliculas.Eliminar();
                        break;
                    case '5':
                        ClientesPeliculas.Mostrar();
                        break;
                    case '0':
                        System.out.println("Ha salido del programa");
                        break;

                    default:
                        System.out.println("Opción incorrecta ...");
                        opcion = '1';
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(NecFlix_Progra01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean esNumerica(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

}
