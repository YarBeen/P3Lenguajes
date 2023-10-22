
package com.pl3.p3lenguajes.symptoms;

import org.jpl7.*;
import java.util.ArrayList;
import java.util.List;
import org.jpl7.Query;
/**
 *
 * @author Yosward Garcia
 */
public class SymptomsConsult {
    
    private Query query;
    
    
    
    public void findSymptoms(String patientName){
        String prologQuery = "find_symptoms('"+ patientName + "', Symptoms)"; 
        query = new Query(prologQuery);
        
        if(query.hasSolution()){
            Term symptomList = query.oneSolution().get("Symptoms");
            List<String> symptons = prologListToJavaList(symptomList);
            System.out.println("Patient " + patientName + "´s symptoms:");
            for(String symptom : symptons){
                System.out.println("- "+ symptom);
            }
        } else{
            System.out.println("Patient " + patientName + "doesn't have symptoms");
        }
        
    }
    
    
    public void isAsymptomatic(String patientName){
        String prologQuery = "is_asymptomatic(" + patientName + ")";
        query = new Query(prologQuery);
        if(query.hasSolution()){
            System.out.println("Patient " + patientName + "is asymptomatic");
        }else{
            System.out.println("Patient " + patientName + "is not asymptomatic");
        }
    }
    
    public void isAsymptomatic(){
        String prologQuery = "is_asymptomatic(X)";
        query = new Query(prologQuery);
        if(query.hasSolution()){
            while(query.hasMoreSolutions()){
                String patientName = query.nextSolution().get("X").toString();
                System.out.println("Patient " + patientName + " is asymptomatic");
            }
        }else{
            System.out.println("No asymptomatic patients found");
        }
    }
    
    
    public void countSymptoms(String patientName, List<String> symptoms) {
        String prologQuery = "count_symptoms('" + patientName + "', " + javaListToPrologList(symptoms) + ", N)";
        query = new Query(prologQuery);
        if (query.hasSolution()) {
            System.out.println("Patient " + patientName + " has " + query.oneSolution().get("N").intValue() + "Symptoms");
        } else {
            System.out.println("Patient " + patientName + " has no Symptom");
        }
    }
    
    
    public void find_count_symptoms(String patientName){
        String prologQuery = "find_count_symptoms(" + patientName + ",NumSymptoms";
        query = new Query(prologQuery);
        if(query.hasMoreSolutions()){
            System.out.println("Patient " + patientName + " has " + query.oneSolution().get("NumSymptoms").intValue() + "Symptoms");
        } else {
            System.out.println("Patient doesn´t exist");
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
