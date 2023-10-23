/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pl3.p3lenguajes.Consulters;
import org.jpl7.JPL;
import org.jpl7.Query;
import org.jpl7.Term;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 *
 * @author Yarman
 */
public class infectionConsulter {
    /*
     * Funcion para imprimir todo el arbol de infeccion
     * Entrada: nada
     * Salida: void
    */
    public void infectorTree (){
        String query = "spread_desease(X,Y).";
        Query q = new Query(query);
        Set<String> resultSet = new HashSet<>();
        // Itera por todas las soluciones
        while(q.hasMoreSolutions()){
             Map<String, Term> solution = q.nextSolution();
             String result = solution.get("Y") +  " propago la enfermedad a " + solution.get("X");
            resultSet.add(result);
        }
        
        for (String result : resultSet) {
                System.out.println(result);
            }
        
        q.close();
        return;
    }
    
    /*
     * Funcion para verificar que un paciente esta infectado
     * Entrada: Nombre del paciente
     * Salida: void
    */
    public void infected(String patientName){
        // Se verifica que si sea paciente
         Query queryPaciente = new Query("paciente("+patientName+").");
        if(!queryPaciente.hasSolution()){
            System.out.println("El paciente no está registrado en el sistema");
            return;
        }
        String query = "infected("+patientName.toLowerCase()+").";
        Query q = new Query(query);
        if(q.hasSolution()){
            System.out.println("El paciente " + patientName +" esta infectado.");
            return;
        }
        System.out.println("El paciente " + patientName +" no esta infectado.");
        
    }
    
    /*
     * Obtener todos los pacientes que esten infectado
     * Entrada: nada
     * Salida: void
    */
    public void infected(){
        String query = "infected(X).";
        Query q = new Query(query);
        if(!q.hasSolution()){
            System.out.println("Consulta invalida");
            return;
        }
        
        // Se itera por todos los ifnectados
        while (q.hasNext()){
            var curr =q.nextSolution();
            
            Term X = curr.get("X");
            
            System.out.println("El paciente " +X+ " esta infectado ");  
        }
        return; 
    }
    
}
