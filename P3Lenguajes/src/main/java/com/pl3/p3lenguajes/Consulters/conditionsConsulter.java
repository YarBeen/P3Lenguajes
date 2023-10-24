/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pl3.p3lenguajes.Consulters;

import java.util.HashSet;
import java.util.Set;

import org.jpl7.Query;
import org.jpl7.Term;

/**
 *
 * @author Yarman
 */
public class conditionsConsulter {
        /**
* Funcione que imprime si un paciente tiene que trabajar en casa
* @param patientName nombre del paciente de la consultas
* Ejemplo: El paciente jose trabaja en casa

* 

*/
    public void workAtHome(String patientName) {
        Query queryPaciente = new Query("paciente(" + patientName + ").");
        if (!queryPaciente.hasSolution()) {
            System.out.println("El paciente no está registrado en el sistema");
            return;
        }
        String query = "workAtHome(" + patientName + ").";
        Query q = new Query(query);
        if (!q.hasSolution()) {
            System.out.println("La persona no trabaja en casa.");
            return;
        }
        while (q.hasNext()) {
            var curr = q.nextSolution();

            System.out.println(patientName + " trabaja en casa");
            return;

        }
        return;
    }
        /**
* Funcione que imprime todos los  pacientes que tienen  que trabajar en casa


* 

*/
    public void workAtHome() {
        String query = "workAtHome(X).";
        Query q = new Query(query);
        if (!q.hasSolution()) {
            System.out.println("Error en consulta invalido.");

            return;
        }
        Set<String> pacienteSinRepeticion = new HashSet<>();
        while (q.hasNext()) {
            var curr = q.nextSolution();

            Term X = curr.get("X");
            String pacienteActual = X.toString();
            if (!pacienteSinRepeticion.contains(pacienteActual)) {

                System.out.println("La persona " + pacienteActual + " trabaja en casa ");
                pacienteSinRepeticion.add(pacienteActual);
            }

        }
        return;
    }
        /**
* Funcione que imprime si un paciente puede viajar
* @param patientName nombre del paciente de la consultas
* Ejemplo: El paciente jose puede viajar

* 

*/
    public void canTravel(String patientName) {
        Query queryPaciente = new Query("paciente(" + patientName + ").");
        if (!queryPaciente.hasSolution()) {
            System.out.println("El paciente no está registrado en el sistema");
            return;
        }
        String query = "canTravel(" + patientName + ").";
        Query q = new Query(query);
        if (!q.hasSolution()) {
            System.out.println("La persona no puede viaja.");
            return;
        }
        while (q.hasNext()) {
            var curr = q.nextSolution();

            System.out.println(patientName + " puede viajar");
            return;

        }
        return;
    }
/**
* Funcione que imprime todos los  pacientes que pueden viajar


* 

*/
    public void canTravel() {
        String query = "canTravel(X).";
        Query q = new Query(query);
        if (!q.hasSolution()) {
            System.out.println("Error en consulta invalido.");
            return;
        }
        Set<String> pacienteSinRepeticion = new HashSet<>();
        while (q.hasNext()) {
            var curr = q.nextSolution();

            Term X = curr.get("X");
            String pacienteActual = X.toString();
            if (!pacienteSinRepeticion.contains(pacienteActual)) {

                System.out.println("La persona " + X + " puede viajar ");
                pacienteSinRepeticion.add(pacienteActual);
            }

        }
        return;
    }
}
