/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pl3.p3lenguajes.Consulters;

import org.jpl7.Query;
import org.jpl7.Term;

/**
 *
 * @author Yarman
 */
public class conditionsConsulter {
     public void workAtHome(String nombrePersona){
        String query = "workAtHome("+nombrePersona+").";
        Query q = new Query(query);
        if(!q.hasSolution()){
            System.out.println("La persona no trabaja en casa.");
            return;
        }
        while (q.hasNext()){
            var curr =q.nextSolution();
            
            
            System.out.println(nombrePersona + " trabaja en casa");
            
            
        }
        return;
    }
    public void workAtHome(){
        String query = "workAtHome(X).";
        Query q = new Query(query);
        if(!q.hasSolution()){
            System.out.println("Error en consulta invalido.");
            return ;
        }
        while (q.hasNext()){
            var curr =q.nextSolution();
            
            Term X = curr.get("X");
            
            System.out.println("La persona " +X+ " trabaja en casa " );
            
            
        }
        return;
    }
     public void canTravel(String nombrePersona){
        String query = "canTravel("+nombrePersona+").";
        Query q = new Query(query);
        if(!q.hasSolution()){
            System.out.println("La persona no puede viaja.");
            return;
        }
        while (q.hasNext()){
            var curr =q.nextSolution();
            
            
            System.out.println(nombrePersona + " puede viajar");
            
            
        }
        return;
    }
    public void canTravel(){
        String query = "canTravel(X).";
        Query q = new Query(query);
        if(!q.hasSolution()){
            System.out.println("Error en consulta invalido.");
            return ;
        }
        while (q.hasNext()){
            var curr =q.nextSolution();
            
            Term X = curr.get("X");
            
            System.out.println("La persona " +X+ " puede viajar " );
            
            
        }
        return;
    }
}
