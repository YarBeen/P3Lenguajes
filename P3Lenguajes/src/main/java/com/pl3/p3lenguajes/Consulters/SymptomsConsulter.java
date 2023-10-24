
package com.pl3.p3lenguajes.Consulters;

import org.jpl7.*;
import java.util.ArrayList;
import java.util.List;
import org.jpl7.Query;
/**
 *
 * @author Yosward Garcia
 */
public class SymptomsConsulter {
    
    private Query query;
    
    
    /*
     * Funcion para encontrar los sintomas de un paciente
     * Ejecuta el query de prolog y convierte la lista de prolog a lista de Java
     * para poder imprimir cada sintoma.
     *
     * Entrada: Nombre del paciente en formato String
     * Salida: void
    */
    public void findSymptoms(String patientName){
        // Se valida de que sea un paciente
        Query queryPaciente = new Query("paciente("+patientName+").");
        if(!queryPaciente.hasSolution()){
            System.out.println("El paciente no está registrado en el sistema");
            return;
        }
        String prologQuery = "find_symptoms('"+ patientName + "', Symptoms)."; 
        query = new Query(prologQuery);
        
        if(query.hasSolution()){
            Term symptomList = query.oneSolution().get("Symptoms");
            // Convertir la lista de prolog a java
            List<String> symptons = prologListToJavaList(symptomList);
            System.out.println("Sintomas de  " + patientName + ":");
            for(String symptom : symptons){
                System.out.println("- "+ symptom);
            }
        } else{
            System.out.println("" + patientName + " no tiene sintomas");
        }
        
    }
    
    /*
     * Funcion que verifica si un paciente es asintomatico
     * Entrada: Nombre del paciente en String
     * Saldida: void
    */
    public void isAsymptomatic(String patientName){
        // Se valida de que sea un paciente
        Query queryPaciente = new Query("paciente("+patientName+").");
        if(!queryPaciente.hasSolution()){
            System.out.println("El paciente no está registrado en el sistema");
            return;
        }
        String prologQuery = "is_asymptomatic(" + patientName + ").";
        query = new Query(prologQuery);
        if(query.hasSolution()){
            System.out.println(" " + patientName + " es asintomatico");
        }else{
            System.out.println("" + patientName + " no es asintomatico.");
        }
    }
    
    /*
     * Funcion que consulta todas las personas que son asintomaticas
     * Entrada: ninguna
     * Salida: void
    */
    public void isAsymptomatic(){
        String prologQuery = "is_asymptomatic(X).";
        query = new Query(prologQuery);
        if(query.hasSolution()){
            System.out.println("Paciente asintomaticos:");
            // Obtiene todas las soluciones a la consulta
            while(query.hasMoreSolutions()){
                String patientName = query.nextSolution().get("X").toString();
                System.out.println("- " + patientName);
            }
        }else{
            System.out.println("No hay pacientes asintomaticos");
        }
    }
    
    /*
     * Funcion para contar los sintomas de un paciente
     * Entrada: Nombre del paciente, lista de los sintomas del paciente
     * Salida: void
    */
    public void countSymptoms(String patientName, List<String> symptoms) {
        // Se valida de que sea un paciente
        Query queryPaciente = new Query("paciente("+patientName+").");
        if(!queryPaciente.hasSolution()){
            System.out.println("El paciente no está registrado en el sistema");
            return;
        }
        // Se convierte la lista de java en lista de prolog y se crea el query
        String prologQuery = "count_symptoms('" + patientName + "', " + javaListToPrologList(symptoms) + ", N).";
        query = new Query(prologQuery);
        if (query.hasSolution()) {
            System.out.println("El paciente " + patientName + " tiene " + query.oneSolution().get("N").intValue() + " sintomas");
        } else {
            System.out.println("El paciente " + patientName + " no tiene sintomas.");
        }
    }
    
    
    /*
     * Funcion para buscar y contar los sintomas de un paciente
     * Entrada: Nombre del paciente
     * Salida: void
    */
    public void findCountSymptoms(String patientName){
        // Se valida de que sea un paciente
        Query queryPaciente = new Query("paciente("+patientName+").");
        if(!queryPaciente.hasSolution()){
            System.out.println("El paciente no está registrado en el sistema");
            return;
        }
        String prologQuery = "find_count_symptoms(" + patientName + ",NumSymptoms).";
        query = new Query(prologQuery);
        if(query.hasSolution()){
            System.out.println("El paciente " + patientName + " tiene " + query.oneSolution().get("NumSymptoms").intValue() + " sintomas");
        } else {
            System.out.println("El paciente no existe");
        }
    }
    
    /*
     * Funcion para verificar si un paciente esta recuperado
     * Entrada: Nombre del paciente
     * Salida: void
    */
    public void recovered(String patientName){
        // Se valida de que sea un paciente
        Query queryPaciente = new Query("paciente("+patientName+").");
        if(!queryPaciente.hasSolution()){
            System.out.println("El paciente no está registrado en el sistema");
            return;
        }
        String prologQuery = "recovered(" + patientName +").";
        query = new Query(prologQuery);
        if(query.hasMoreSolutions()){
            System.out.println("El paciente " + patientName + " se ha recuperado.");
        } else {
            System.out.println("No se ha recuperado aun");
        }
    }
    
    /*
     * Funcion para obtener todas las personas recuperadas
     * Entrada: ninguna
     * Salida: void
    */
    public void recovered(){
        String prologQuery = "recovered(X).";
        query = new Query(prologQuery);
        if(query.hasSolution()){
            System.out.println("Pacientes recuperados:");
            // Itera por todas las soluciones de la consulta
            while(query.hasMoreSolutions()){
                String patientName = query.nextSolution().get("X").toString();
                System.out.println("- " + patientName);
            }
        }else{
            System.out.println("No hay pacientes recuperados");
        }
    }
    
    
    /*
     * Funcion para convertir una lista de java a lista de prolog
     * Entrada: una lista de String
     * Salida: String de con el formato de una lista en prolog
    */
    private String javaListToPrologList(List<String> list) {
        StringBuilder prologList = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            prologList.append("'" + list.get(i) + "'");
            if (i < list.size() - 1) {
                prologList.append(", ");
            }
        }
        prologList.append("]");
        return prologList.toString();
    }
    
    /*
     * Funcion para convertir una lista de prolog en una lista de java
     * Entrada: Term que es una lista de prolog
     * Salida: Una lista de String
    */
    private List<String> prologListToJavaList(Term prologList) {
        List<String> javaList = new ArrayList<>();
        while (prologList.arity() == 2) {
            Term currentElement = prologList.arg(1);
            javaList.add(currentElement.toString());
            prologList = prologList.arg(2);
        }
        return javaList;
    }
}