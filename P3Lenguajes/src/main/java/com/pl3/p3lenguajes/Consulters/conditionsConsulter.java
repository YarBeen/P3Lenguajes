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
     public void workAtHome(String patientName){
          Query queryPaciente = new Query("paciente("+patientName+").");
        if(!queryPaciente.hasSolution()){
            System.out.println("El paciente no está registrado en el sistema");
        }
        String query = "workAtHome("+patientName+").";
        Query q = new Query(query);
        if(!q.hasSolution()){
            System.out.println("La persona no trabaja en casa.");
            return;
        }
        while (q.hasNext()){
            var curr =q.nextSolution();
            
            
            System.out.println(patientName + " trabaja en casa");
            
            
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
     public void canTravel(String patientName){
          Query queryPaciente = new Query("paciente("+patientName+").");
        if(!queryPaciente.hasSolution()){
            System.out.println("El paciente no está registrado en el sistema");
        }
        String query = "canTravel("+patientName+").";
        Query q = new Query(query);
        if(!q.hasSolution()){
            System.out.println("La persona no puede viaja.");
            return;
        }
        while (q.hasNext()){
            var curr =q.nextSolution();
            
            
            System.out.println(patientName + " puede viajar");
            
            
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
