/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pl3.p3lenguajes.Consulters;

import org.jpl7.JPL;
import org.jpl7.Query;
import org.jpl7.Term;

/**
 *
 * @author Yarman
 */
public class vaccinesConsulter {
    public void vaccineByAge(String patientName){
         Query queryPaciente = new Query("paciente("+patientName+").");
        if(!queryPaciente.hasSolution()){
            System.out.println("El paciente no está registrado en el sistema");
            return;
        }
        String query = "vaccineByAge("+patientName+",Vaccine).";
        Query q = new Query(query);
        if(!q.hasSolution()){
            System.out.println("Nombre invalido.");
            return;
        }
        while (q.hasNext()){
            var curr =q.nextSolution();
            
            //Term X = curr.get("X");
            Term vaccine = curr.get("Vaccine");
            System.out.println("Vacuna " + vaccine);
            
            
        }
        return;
    }
    public void vaccineByAge(){
        String query = "vaccineByAge(X,Vaccine).";
        Query q = new Query(query);
        if(!q.hasSolution()){
            System.out.println("Error en consulta invalido.");
            return ;
        }
        while (q.hasMoreSolutions()){
            var curr =q.nextSolution();
            
            Term X = curr.get("X");
            Term vaccine = curr.get("Vaccine");
            System.out.println("El paciente " +X+ " deberia utilizar la vacuna " + vaccine);
            
            
        }
        return;
    }
    public void vaccinesByPacient(){
         String query = "howManyVaccines(X,Result).";
        Query q = new Query(query);
         if(!q.hasSolution()){
            System.out.println("Nombre invalido.");
            return ;
        }
         while (q.hasNext()){
            var curr =q.nextSolution();
            
            Term X = curr.get("X");
//            if(X==null){
//                System.out.println("La persona no está registrado");
//                return;
//            }
            Term quantity = curr.get("Result");
            
            System.out.println("El paciente " +X+ " tiene " + quantity + " vacunas");
            
            
        }
    }
    public void fullyVaccinedPacient(){
           String query = "allVaccines(X).";
        Query q = new Query(query);
         if(!q.hasSolution()){
            System.out.println("Nombre invalido.");
            return ;
        }
         while (q.hasNext()){
            var curr =q.nextSolution();
            
//            Term X = curr.get("X");
//            if(X==null){
//                System.out.println("La persona no está registrado");
//                return;
//            }
            Term X = curr.get("X");
            
            System.out.println("El paciente " +X+ "  esta completamente vacunado ");
            
            
        }
        return;
    }
       public void vaccinesByPacient(String patientName){
            Query queryPaciente = new Query("paciente("+patientName+").");
        if(!queryPaciente.hasSolution()){
            System.out.println("El paciente no está registrado en el sistema");
            return;
        }
         String query = "howManyVaccines("+patientName+",Result).";
        Query q = new Query(query);
         if(!q.hasSolution()){
            System.out.println("Nombre invalido.");
            return ;
        }
         while (q.hasNext()){
            var curr =q.nextSolution();
            
//            Term X = curr.get("X");
//            if(X==null){
//                System.out.println("La persona no está registrado");
//                return;
//            }
            Term quantity = curr.get("Result");
            
            System.out.println("El paciente " +patientName+ " tiene " + quantity + " vacunas");
            
            
        }
    }
    
    public void recommendedReforceVaccine(String patientName){
         Query queryPaciente = new Query("paciente("+patientName+").");
        if(!queryPaciente.hasSolution()){
            System.out.println("El paciente no está registrado en el sistema");
            return;
        }
        String query = "recommendedReforceVaccine("+patientName+",Vaccine).";
        Query q = new Query(query);
         if(!q.hasSolution()){
            System.out.println("Nombre invalido.");
            return ;
        }
         while (q.hasNext()){
            var curr =q.nextSolution();
            
//            Term X = curr.get("X");
//            if(X==null){
//                System.out.println("La persona no está registrado");
//                return;
//            }
            Term vaccine = curr.get("Vaccine");
            
            System.out.println("El paciente " +patientName+ " necesita " + vaccine);
            
            
        }
        return;
        
    }
    public void recommendedReforceVaccine(){
        String query = "recommendedReforceVaccine(X,Vaccine).";
        Query q = new Query(query);
         if(!q.hasSolution()){
            System.out.println("Nombre invalido.");
            return ;
        }
         while (q.hasNext()){
            var curr =q.nextSolution();
            
            Term X = curr.get("X");
//            if(X==null){
//                System.out.println("La persona no está registrado");
//                return;
//            }
            Term vaccine = curr.get("Vaccine");
            
            System.out.println("El paciente " +X+ " necesita " + vaccine);
            
            
        }
        return;
        
    }
    
}
