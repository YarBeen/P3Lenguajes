
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
    
    
    
    public void findSymptoms(String patientName){
         Query queryPaciente = new Query("paciente("+patientName+").");
        if(!queryPaciente.hasSolution()){
            System.out.println("El paciente no está registrado en el sistema");
            return;
        }
        String prologQuery = "find_symptoms('"+ patientName + "', Symptoms)."; 
        query = new Query(prologQuery);
        
        if(query.hasSolution()){
            Term symptomList = query.oneSolution().get("Symptoms");
            List<String> symptons = prologListToJavaList(symptomList);
            System.out.println("Sintomas de  " + patientName + ":");
            for(String symptom : symptons){
                System.out.println("- "+ symptom);
            }
        } else{
            System.out.println("" + patientName + " no tiene sintomas");
        }
        
    }
    
    
    public void isAsymptomatic(String patientName){
        
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
    
    public void isAsymptomatic(){
        String prologQuery = "is_asymptomatic(X).";
        query = new Query(prologQuery);
        if(query.hasSolution()){
            System.out.println("Paciente asintomaticos:");
            while(query.hasMoreSolutions()){
                String patientName = query.nextSolution().get("X").toString();
                System.out.println("- " + patientName);
            }
        }else{
            System.out.println("No hay pacientes asintomaticos");
        }
    }
    
    
    public void countSymptoms(String patientName, List<String> symptoms) {
         Query queryPaciente = new Query("paciente("+patientName+").");
        if(!queryPaciente.hasSolution()){
            System.out.println("El paciente no está registrado en el sistema");
            return;
        }
        String prologQuery = "count_symptoms('" + patientName + "', " + javaListToPrologList(symptoms) + ", N).";
        query = new Query(prologQuery);
        if (query.hasSolution()) {
            System.out.println("El paciente " + patientName + " tiene " + query.oneSolution().get("N").intValue() + " sintomas");
        } else {
            System.out.println("El paciente " + patientName + " no tiene sintomas.");
        }
    }
    
    
    public void findCountSymptoms(String patientName){
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
    
    
    public void recovered(String patientName){
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
    
    public void recovered(){
        String prologQuery = "recovered(X).";
        query = new Query(prologQuery);
        if(query.hasSolution()){
            System.out.println("Pacientes recuperados:");
            while(query.hasMoreSolutions()){
                String patientName = query.nextSolution().get("X").toString();
                System.out.println("- " + patientName);
            }
        }else{
            System.out.println("No hay pacientes recuperados");
        }
    }
    
    
    
    
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