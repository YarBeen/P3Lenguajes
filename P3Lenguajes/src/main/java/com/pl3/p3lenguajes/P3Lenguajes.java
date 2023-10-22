/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.pl3.p3lenguajes;

import com.pl3.p3lenguajes.Consulters.vaccinesConsulter;
import org.jpl7.*;
import java.io.File;
import org.jpl7.Query;

/**
 *
 * @author Yarman
 */
public class P3Lenguajes {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String prologQuery = "consult('C:\\\\final_rules.pl')";
        Query consultQuery = new Query(prologQuery);
        if (consultQuery.hasSolution()) {
            System.out.println("Correct");
        }
        vaccinesConsulter consulter = new vaccinesConsulter();
//        consulter.vaccineByAge("eduardo");
//        consulter.vaccineByAge("juan");
//        consulter.vaccineByAge("roxas");
//        System.out.println("Todas");
//        consulter.vaccineByAge();
//        consulter.recommendedReforceVaccine("empty");
//        consulter.recommendedReforceVaccine("eduardo");
//        consulter.recommendedReforceVaccine("juan");
//        consulter.recommendedReforceVaccine("maria");
           consulter.recommendedReforceVaccine();
           consulter.vacunasPorPaciente("eduardo");

    }
}
