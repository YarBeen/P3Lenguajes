/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.pl3.p3lenguajes;
import org.jpl7.*;
import java.io.File;
import org.jpl7.Query;

/**
 *
 * @author Yarman
 */
public class P3Lenguajes {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String prologQuery = "consult('C:\\\\Users\\\\User\\\\Desktop\\\\Pruebas.pl')";
Query consultQuery = new Query(prologQuery);
if (consultQuery.hasSolution()){
    System.out.println("Correct");
}
    Query queryDePrueba = new Query("es_perro(dblacky)");
     Query queryDePrueba2 = new Query("es_perro(blacky)");
  if(queryDePrueba.hasSolution()){
      System.out.println("true");
  }
  else{
            System.out.println("false");

  }
    }
}
