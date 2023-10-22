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
        String prologQuery = "serious_case('" + patientName + "')"; 
        query = new Query(prologQuery);
        
        if(query.hasSolution()){
            System.out.println("Patient " + patientName + " has trouble breathing");
            System.out.println(patientName + " is a serious case");
        } else{
            System.out.println(patientName + "is not a serious case");
        }
    }
    
    
}
