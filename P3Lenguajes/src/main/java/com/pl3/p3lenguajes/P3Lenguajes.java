/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.pl3.p3lenguajes;


import org.jpl7.Query;

import java.util.Scanner;

/**
 *
 * @author Yarman
 */
public class P3Lenguajes {

    public static void main(String[] args) {

        String prologQuery = "consult('C:\\\\final_rules.pl')";
        try {
            Query consultQuery = new Query(prologQuery);
            if (!consultQuery.hasSolution()) {
                throw new Exception();
            }

        } catch (Exception e) {
            System.out.println("Error al conectarse a prolog");
            return;
        }

        System.out.println();

        System.out.println("Conexión a Prolog exitosa!");
        System.out.println("Bienvenido al sistema de consultas de prolog!");
        
        Scanner scanner = new Scanner(System.in);
        menuRunner menu = new menuRunner(scanner);

        menu.run();

        scanner.close();


    }
}
