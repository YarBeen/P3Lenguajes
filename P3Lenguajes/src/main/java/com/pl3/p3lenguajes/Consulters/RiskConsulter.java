/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pl3.p3lenguajes.Consulters;

import org.jpl7.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Yosward Garcia
 */
public class RiskConsulter {
    
    private Query query;
    
    
    public void seriousCase(String patientName){
        String prologQuery = "serious_case(" + patientName + ")."; 
        query = new Query(prologQuery);
        
        if(query.hasSolution()){
            System.out.println("Patient " + patientName + " has trouble breathing");
            System.out.println(patientName + " is a serious case");
        } else{
            System.out.println(patientName + "is not a serious case");
        }
    }
    
    public void seriousCase(){
        String prologQuery = "serious_case(X).";
        query = new Query(prologQuery);
        if(query.hasSolution()){
            System.out.println("Patients who are serious cases:");
            while(query.hasMoreSolutions()){
                String patientName = query.nextSolution().get("X").toString();
                System.out.println("- " + patientName);
            }
        }else{
            System.out.println("There's no serious cases");
        }
    }
    
    public void hasRiskFactor(String patientName){
        String prologQuery = "has_risk_factor(" + patientName + ")."; 
        query = new Query(prologQuery);
        
        if(query.hasSolution()){
            System.out.println("Patient " + patientName + " has a risk factor");
            System.out.println("Is an elder or has a special condition");
        } else{
            System.out.println(patientName + "doesn't have a rsk factor");
        }
    }
    
    public void hasRiskFactor(){
        String prologQuery = "has_risk_factor(X)."; 
        query = new Query(prologQuery);
        
        if(query.hasSolution()){
            System.out.println("Patients with high risk factor:");
            while(query.hasMoreSolutions()){
                String patientName = query.nextSolution().get("X").toString();
                System.out.println("- " + patientName);
            }
        }else{
            System.out.println("There's no spatiens with risk factor");
        }
    }
    
    public void isPriority(){
        String prologQuery = "is_priority(X)."; 
        query = new Query(prologQuery);
        
        if(query.hasSolution()){
            System.out.println("Patients who are priority:");
            while(query.hasMoreSolutions()){
                String patientName = query.nextSolution().get("X").toString();
                System.out.println("- " + patientName);
            }
        }else{
            System.out.println("There's no priority patients");
        }
    }
    
    
    public void isPriority(String patientName){
        String prologQuery = "is_priority(" + patientName + ")."; 
        query = new Query(prologQuery);
        
        if(query.hasSolution()){
            System.out.println("Patient " + patientName + " is a priority");
        } else{
            System.out.println(patientName + "Isn't a priority");
        }
    }
}