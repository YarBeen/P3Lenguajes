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
public class suspicionConsulter {
    public void suspicious(){
         String query = "suspicious(X).";
        Query q = new Query(query);
        if(!q.hasSolution()){
            System.out.println("Consulta invalida");
            return;
        }
         
        while (q.hasNext()){
            var curr =q.nextSolution();
            
            Term X = curr.get("X");
            
            System.out.println("El paciente " +X+ " es sospechoso. ");
            
            
        }
        return;
    }
     public int suspicious(String patientName){
          Query queryPaciente = new Query("paciente("+patientName+").");
        if(!queryPaciente.hasSolution()){
            System.out.println("El paciente no está registrado en el sistema");
        }
         String query = "suspicious("+patientName+").";
        Query q = new Query(query);
        if(!q.hasSolution()){
          //  System.out.println("Consulta invalida");
            return -1;
        }
         
        while (q.hasNext()){
            var curr =q.nextSolution();
            
            
            
            System.out.println("El paciente " +patientName+ " es sospechoso. ");
            return 0;
            
            
        }
        return 0;
    }
     
     public void mediumLowSuspicious(){
         String query = "mediumLowSuspicious(X).";
        Query q = new Query(query);
        if(!q.hasSolution()){
            System.out.println("Consulta invalida");
            return ;
        }
         
        while (q.hasNext()){
            var curr =q.nextSolution();
            
            Term X = curr.get("X");
            
            System.out.println("El paciente " +X+ " tiene sospecha media. ");
            
            
        }
        return;
    }
     public int mediumLowSuspicious(String patientName){
          Query queryPaciente = new Query("paciente("+patientName+").");
        if(!queryPaciente.hasSolution()){
            System.out.println("El paciente no está registrado en el sistema");
            return -1;
        }
         String query = "mediumLowSuspicious("+patientName+").";
        Query q = new Query(query);
        if(!q.hasSolution()){
            //System.out.println("Consulta invalida");
            return -1;
        }
         
        while (q.hasNext()){
            var curr =q.nextSolution();
            
            
            
            System.out.println("El paciente " +patientName+ " tiene sospecha media. ");
            return 0;
            
            
        }
        return 0;
    }
     
       public void lowSuspicious(){
         String query = "lowSuspicious(X).";
        Query q = new Query(query);
        if(!q.hasSolution()){
            //System.out.println("Consulta invalida");
            return;
        }
         
        while (q.hasNext()){
            var curr =q.nextSolution();
            
            Term X = curr.get("X");
            
            System.out.println("El paciente " +X+ " tiene pocas posibilidades de estar infectado. ");
            
            
        }
        return;
    }
     public int lowSuspicious(String patientName){
          Query queryPaciente = new Query("paciente("+patientName+").");
        if(!queryPaciente.hasSolution()){
            System.out.println("El paciente no está registrado en el sistema");
            return -1;
        }
         String query = "lowSuspicious("+patientName+").";
        Query q = new Query(query);
        if(!q.hasSolution()){
          //  System.out.println("Consulta invalida");
            return -1;
        }
         
        while (q.hasNext()){
            var curr =q.nextSolution();
            
            
            
            System.out.println("El paciente " +patientName+ " tiene pocas posibilidades de estar infectado. ");
            return 0;
            
            
        }
        return 0;
    }
    
}
