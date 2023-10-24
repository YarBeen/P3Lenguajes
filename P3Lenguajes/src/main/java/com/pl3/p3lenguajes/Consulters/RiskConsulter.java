/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pl3.p3lenguajes.Consulters;

import org.jpl7.*;
/**
 *
 * @author Yosward Garcia
 */
public class RiskConsulter {
    
    private Query query;
    
    /*
     * Verifica si un paciente presenta un caso serio
     * Entrada: Nombre del paciente
     * Salida: void
    */
    public void seriousCase(String patientName){
        // verifica si es un paciente
        Query queryPaciente = new Query("paciente("+patientName+").");
        if(!queryPaciente.hasSolution()){
            System.out.println("El paciente no está registrado en el sistema");
            return;
        }
        String prologQuery = "serious_case(" + patientName + ")."; 
        query = new Query(prologQuery);
        
        if(query.hasSolution()){
            System.out.println("El paciente " + patientName + " tiene problemas al respirar");
            System.out.println(patientName + " es un caso serio.");
        } else{
            System.out.println(patientName + " no es un caso serio.");
        }
    }
    
    /*
     * Funcion para obtener todos los casos serios
     * Entrada: nada
     * Salida: void
    */
    public void seriousCase(){
        String prologQuery = "serious_case(X).";
        query = new Query(prologQuery);
        if(query.hasSolution()){
            System.out.println("Casos serios:");
            // Se iteran por todas las soluciones
            while(query.hasMoreSolutions()){
                String patientName = query.nextSolution().get("X").toString();
                System.out.println("- " + patientName);
            }
        }else{
            System.out.println("No existen casos serios");
        }
    }
    
    /*
     * Funcion para determinar si un paciente tiene un facotr de riesgo
     * Entrada: Nombre del paciente
     * Salida: void
    */
    public void hasRiskFactor(String patientName){
        // Se verifica que si sea un paciente
         Query queryPaciente = new Query("paciente("+patientName+").");
        if(!queryPaciente.hasSolution()){
            System.out.println("El paciente no está registrado en el sistema");
            return;
        }
        String prologQuery = "has_risk_factor(" + patientName + ")."; 
        query = new Query(prologQuery);
        
        if(query.hasSolution()){
            System.out.println("El paciente " + patientName + " tiene factor de riesgo");
            System.out.println("Es un anciente o posee un condicion");
        } else{
            System.out.println(patientName + " no tiene factor de riesgo.");
        }
    }
    
    /*
     * Funcion para obtener todos los pacientes que tienen una factor de riesgo
     * Entrada: nada
     * Salida: void
    */
    public void hasRiskFactor(){
        String prologQuery = "has_risk_factor(X)."; 
        query = new Query(prologQuery);
        
        if(query.hasSolution()){
            System.out.println("Pacientes con factor de riesgo:");
            // Itera por todas las soluciones de la consulta
            while(query.hasMoreSolutions()){
                String patientName = query.nextSolution().get("X").toString();
                System.out.println("- " + patientName);
            }
        }else{
            System.out.println("No hay pacientes con factor de riesgo.");
        }
    }
    
    /*
     * Funcion para determinar que pacientes son prioridades
     * Entrada: nada
     * Salida: void
    */
    public void isPriority(){
        String prologQuery = "is_priority(X)."; 
        query = new Query(prologQuery);
        
        if(query.hasSolution()){
            System.out.println("Pacientes con prioridad:");
            // Se itera por todas las soluciones
            while(query.hasMoreSolutions()){
                String patientName = query.nextSolution().get("X").toString();
                System.out.println("- " + patientName);
            }
        }else{
            System.out.println("No existen pacientes con prioridad");
        }
    }
    
    /*
     * Funcion para determinar si un paciente es prioridad
     * Entrada: Nombre del paciente
     * Salida: void
    */
    public void isPriority(String patientName){
        // Se verifica que sea un paciente
         Query queryPaciente = new Query("paciente("+patientName+").");
        if(!queryPaciente.hasSolution()){
            System.out.println("El paciente no está registrado en el sistema");
            return;
        }
        String prologQuery = "is_priority(" + patientName + ")."; 
        query = new Query(prologQuery);
        
        if(query.hasSolution()){
            System.out.println("El paciente " + patientName + " es una prioridad.");
        } else{
            System.out.println(patientName + " no es una prioridad.");
        }
    }
}