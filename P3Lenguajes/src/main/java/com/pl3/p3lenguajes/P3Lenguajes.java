/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.pl3.p3lenguajes;
<<<<<<< HEAD

import com.pl3.p3lenguajes.Consulters.infectionConsulter;
import com.pl3.p3lenguajes.Consulters.vaccinesConsulter;
=======
>>>>>>> 1de9f6461402e4a450c8f68670d65d5f5a0e06d4
import org.jpl7.*;
import java.io.File;
import org.jpl7.Query;

import java.util.Scanner;

/**
 *
 * @author Yarman
 */
public class P3Lenguajes {

    public static void main(String[] args) {
<<<<<<< HEAD

        String prologQuery = "consult('C:\\\\final_rules.pl')";
        try {
            Query consultQuery = new Query(prologQuery);
        } catch (Exception e) {
            System.out.println("Error al conectarse a prolog");
            return;
        }
        System.out.println("Conexión a Prolog exitosa!");
        System.out.println("Bienvenido al sistema de consultas de prolog!");
        int opcion;
        Scanner scanner = new Scanner(System.in);
        menuRunner menu = new menuRunner(scanner);

        do {
            System.out.println("Menu:");
            System.out.println("1. Consultas de Vacunas");
            System.out.println("2. Consultas de Infecciones");
            System.out.println("3. Consultas de Sospechas");
            System.out.println("4. Consultas de Condiciones");
            System.out.println("5. Salir");
            System.out.print("Digite su opcion: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    
                    System.out.println("You selected Option 1");

                    break;
                case 2:
                    System.out.println("You selected Option 2");

                    break;
                case 3:
                    System.out.println("You selected Option 3");

                    break;
                case 4:
                    System.out.println("Exiting the program");
                    break;
                case 5:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion Invalidad2");
                    break;
            }
        } while (opcion != 5);

        scanner.close();

=======
        System.out.println("Hello World!");
        
>>>>>>> 1de9f6461402e4a450c8f68670d65d5f5a0e06d4
    }
}
