/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pl3.p3lenguajes;

import com.pl3.p3lenguajes.Consulters.RiskConsulter;
import com.pl3.p3lenguajes.Consulters.SymptomsConsulter;
import java.util.Scanner;
import com.pl3.p3lenguajes.Consulters.conditionsConsulter;
import com.pl3.p3lenguajes.Consulters.infectionConsulter;
import com.pl3.p3lenguajes.Consulters.suspicionConsulter;
import com.pl3.p3lenguajes.Consulters.vaccinesConsulter;
import java.util.InputMismatchException;

/**
 *
 * @author Yarman
 */
public class menuRunner {

    private conditionsConsulter condConsult;
    private infectionConsulter infConsult;
    private suspicionConsulter susConsult;
    private vaccinesConsulter vacConsult;
    private RiskConsulter riskConsult;
    private SymptomsConsulter sympConsult;
    private Scanner scanner;

    public menuRunner(Scanner scanner) {
        this.condConsult = new conditionsConsulter();
        this.infConsult = new infectionConsulter();
        this.susConsult = new suspicionConsulter();
        this.vacConsult = new vaccinesConsulter();
        this.sympConsult = new SymptomsConsulter();
        this.riskConsult = new RiskConsulter();

        this.scanner = scanner;

    }

    public void pacientVaccineMenuRun() {
        int opcion;
        String paciente;
        do {

            System.out.println("1. Consultar las vacunas que se puede poner un paciente");
            System.out.println("2. Consultar cuantas veces se ha vacunado un paciente");
            System.out.println("3. Consultar vacunas de refuerzo recomendadas para un paciente");
            System.out.println("4. Salir");

            System.out.print("Digite su opcion: ");
            try {

                opcion = scanner.nextInt();

            } catch (InputMismatchException e) {
                opcion = 0;
                System.out.println("Entrada invalida.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Digite el nombre del paciente a consultar.");
                    paciente = scanner.nextLine();
                    System.out.println(paciente);
                    this.vacConsult.vaccineByAge(paciente);
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();

                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Digite el nombre del paciente a consultar.");
                    paciente = scanner.nextLine();
                    System.out.println(paciente);
                    this.vacConsult.vaccinesByPacient(paciente);
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Digite el nombre del paciente a consultar.");
                    paciente = scanner.nextLine();
                    System.out.println(paciente);
                    this.vacConsult.recommendedReforceVaccine(paciente);
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();
                    break;
                case 4:

                    break;

                default:
                    System.out.println("Opcion Invalidad");
                    break;
            }
        } while (opcion != 4);
    }

    public void generalVaccineMenuRun() {
        int opcion;
        do {

            System.out.println("1. Consultar las vacunas que se puede poner cada paciente");
            System.out.println("2. Consultar cuantas veces se ha vacunado cada paciente");
            System.out.println("3. Consultar paciente que estan completamente vacunados");
            System.out.println("4. Consultar vacunas de refuerzo recomendadas por paciente");
            System.out.println("5. Salir");

            System.out.print("Digite su opcion: ");
            try {

                opcion = scanner.nextInt();

            } catch (InputMismatchException e) {
                opcion = 0;
                System.out.println("Entrada invalida.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    this.vacConsult.vaccineByAge();
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();
                    scanner.nextLine();

                    break;
                case 2:
                    this.vacConsult.vaccinesByPacient();
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 3:
                    this.vacConsult.fullyVaccinedPacient();
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 4:
                    this.vacConsult.recommendedReforceVaccine();
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 5:

                    break;

                default:
                    System.out.println("Opcion Invalidad");
                    break;
            }
        } while (opcion != 5);
    }

    public void pacientInfectionMenuRun() {
        int opcion;
        String paciente;
        do {

            System.out.println("1. Consultar si un paciente está infectado");
            System.out.println("2. Salir");

            System.out.print("Digite su opcion: ");
            try {

                opcion = scanner.nextInt();

            } catch (InputMismatchException e) {
                opcion = 0;
                System.out.println("Entrada invalida.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Digite el nombre del paciente a consultar.");
                    paciente = scanner.nextLine();
                    System.out.println(paciente);
                    this.infConsult.infected(paciente);
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();

                    break;
                case 2:

                    break;

                default:
                    System.out.println("Opcion Invalidad");
                    break;
            }
        } while (opcion != 2);
    }

    public void pacientConditionMenuRun() {
        int opcion;
        String paciente;
        do {

            System.out.println("1. Consultar si un paciente lleva trabajo remoto");
            System.out.println("2. Consultar si un paciente puede viajar");
            System.out.println("3. Salir");

            System.out.print("Digite su opcion: ");
            try {

                opcion = scanner.nextInt();

            } catch (InputMismatchException e) {
                opcion = 0;
                System.out.println("Entrada invalida.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Digite el nombre del paciente a consultar.");
                    paciente = scanner.nextLine();
                    System.out.println(paciente);
                    this.condConsult.workAtHome(paciente);
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();

                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Digite el nombre del paciente a consultar.");
                    paciente = scanner.nextLine();
                    System.out.println(paciente);
                    this.condConsult.canTravel(paciente);
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();
                    break;
                case 3:

                    break;

                default:
                    System.out.println("Opcion Invalidad");
                    break;
            }
        } while (opcion != 3);
    }

    public void generalConditionMenuRun() {
        int opcion;
        do {

            System.out.println("1. Ver pacientes que fueron mandados a trabajo remoto");
            System.out.println("2. Ver pacientes que pueden viajar");

            System.out.println("3. Salir");

            System.out.print("Digite su opcion: ");
            try {

                opcion = scanner.nextInt();

            } catch (InputMismatchException e) {
                opcion = 0;
                System.out.println("Entrada invalida.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    this.condConsult.workAtHome();
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();
                    scanner.nextLine();

                    break;
                case 2:
                    this.condConsult.canTravel();
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 3:

                    break;

                default:
                    System.out.println("Opcion Invalidad");
                    break;
            }
        } while (opcion != 3);
    }

    public void pacientSymptomsMenuRun() {
        int opcion;
        String paciente;
        do {

            System.out.println("1. Consultar si un paciente es asintomático");
            System.out.println("2. Consultar cuantos sintomas tiene un paciente");
            System.out.println("3. Consultar cuales sintomas tiene un paciente");
            System.out.println("4. Consultar si un paciente se recuperó");
            System.out.println("5. Salir");

            System.out.print("Digite su opcion: ");
            try {

                opcion = scanner.nextInt();

            } catch (InputMismatchException e) {
                opcion = 0;
                System.out.println("Entrada invalida.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Digite el nombre del paciente a consultar.");
                    paciente = scanner.nextLine();
                    System.out.println(paciente);
                    this.sympConsult.isAsymptomatic(paciente);
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();

                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Digite el nombre del paciente a consultar.");
                    paciente = scanner.nextLine();
                    System.out.println(paciente);
                    this.sympConsult.findCountSymptoms(paciente);
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Digite el nombre del paciente a consultar.");
                    paciente = scanner.nextLine();
                    System.out.println(paciente);
                    this.sympConsult.findSymptoms(paciente);
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("Digite el nombre del paciente a consultar.");
                    paciente = scanner.nextLine();
                    System.out.println(paciente);
                    this.sympConsult.recovered(paciente);
                    System.out.println("\n\n Digite cualquier tecla para continuar");
                    break;
                case 5:

                    break;

                default:
                    System.out.println("Opcion Invalidad");
                    break;
            }
        } while (opcion != 5);
    }

    public void generalSymptomsMenuRun() {
        int opcion;
        do {

            System.out.println("1. Ver pacientes asintomáticos");
            System.out.println("2. Ver pacientes recuperados");

            System.out.println("3. Salir");

            System.out.print("Digite su opcion: ");
            try {

                opcion = scanner.nextInt();

            } catch (InputMismatchException e) {
                opcion = 0;
                System.out.println("Entrada invalida.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    this.sympConsult.isAsymptomatic();
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();
                    scanner.nextLine();

                    break;
                case 2:
                    this.sympConsult.recovered();
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 3:

                    break;
                default:
                    System.out.println("Opcion Invalidad");
                    break;
            }
        } while (opcion != 3);
    }

    public void pacientRiskMenuRun() {
        int opcion;
        String paciente;
        do {

            System.out.println("1. Consultar si un paciente tiene caso severo");
            System.out.println("2. Consultar si un paciente tiene factor de riesgo");
            System.out.println("3. Consultar si un paciente es prioridad");
            System.out.println("4. Salir");

            System.out.print("Digite su opcion: ");
            try {

                opcion = scanner.nextInt();

            } catch (InputMismatchException e) {
                opcion = 0;
                System.out.println("Entrada invalida.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Digite el nombre del paciente a consultar.");
                    paciente = scanner.nextLine();
                    System.out.println(paciente);
                    this.riskConsult.seriousCase(paciente);
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();

                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Digite el nombre del paciente a consultar.");
                    paciente = scanner.nextLine();
                    System.out.println(paciente);
                    this.riskConsult.hasRiskFactor(paciente);
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Digite el nombre del paciente a consultar.");
                    paciente = scanner.nextLine();
                    System.out.println(paciente);
                    this.riskConsult.isPriority(paciente);
                    System.out.println("\n\n Digite cualquier tecla para continuar");
                    break;
                case 4:

                    break;

                default:
                    System.out.println("Opcion Invalidad");
                    break;
            }
        } while (opcion != 4);
    }

    public void generalRiskMenuRun() {
        int opcion;
        do {

            System.out.println("1.Ver pacientes con casos severos");
            System.out.println("2. Ver pacientes con factor de riesgo");
            System.out.println("3. Ver pacientes de prioridad");

            System.out.println("4. Salir");

            System.out.print("Digite su opcion: ");
            try {

                opcion = scanner.nextInt();

            } catch (InputMismatchException e) {
                opcion = 0;
                System.out.println("Entrada invalida.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    this.riskConsult.seriousCase();
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();
                    scanner.nextLine();

                    break;
                case 2:
                    this.riskConsult.hasRiskFactor();
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 3:
                    this.riskConsult.isPriority();
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 4:

                    break;

                default:
                    System.out.println("Opcion Invalidad");
                    break;
            }
        } while (opcion != 4);
    }

    public void pacientSuspicionMenuRun() {
        int opcion;
        int sumCondicionPaciente;
        String paciente;
        do {

            System.out.println("1. Ver condicion de sospecha de paciente");

            System.out.println("2. Salir");

            System.out.print("Digite su opcion: ");
            try {

                opcion = scanner.nextInt();

            } catch (InputMismatchException e) {
                opcion = 0;
                System.out.println("Entrada invalida.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    sumCondicionPaciente = 0;
                    scanner.nextLine();
                    System.out.println("Digite el nombre del paciente a consultar.");
                    paciente = scanner.nextLine();
                    System.out.println(paciente);
                    sumCondicionPaciente += this.susConsult.suspicious(paciente);
                    if (sumCondicionPaciente == -2) {
                        System.out.println("El paciente no está registrado en el sistema");
                        System.out.println("\n\n Digite cualquier tecla para continuar");

                        scanner.nextLine();
                        break;
                    }
                    if (sumCondicionPaciente == 0) {

                        System.out.println("\n\n Digite cualquier tecla para continuar");

                        scanner.nextLine();
                        break;
                    }
                    sumCondicionPaciente += this.susConsult.lowSuspicious(paciente);
                    if (sumCondicionPaciente == -1) {

                        System.out.println("\n\n Digite cualquier tecla para continuar");

                        scanner.nextLine();
                        break;
                    }
                    sumCondicionPaciente += this.susConsult.mediumLowSuspicious(paciente);
                    if (sumCondicionPaciente == -3) {
                        System.out.println("El paciente no es sospechoso de nada.");
                    }
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();

                    break;
                case 2:

                    break;

                default:
                    System.out.println("Opcion Invalidad");
                    break;
            }
        } while (opcion != 2);
    }

    public void generalSuspicionMenuRun() {
        int opcion;
        do {

            System.out.println("1. Ver los pacientes sospechosos");
            System.out.println("2. Ver los pacientes con sospecha media");
            System.out.println("3. Ver los pacientes con sospecha baja");

            System.out.println("4. Salir");

            System.out.print("Digite su opcion: ");
            try {

                opcion = scanner.nextInt();

            } catch (InputMismatchException e) {
                opcion = 0;
                System.out.println("Entrada invalida.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    this.susConsult.suspicious();
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();
                    scanner.nextLine();

                    break;
                case 2:
                    this.susConsult.mediumLowSuspicious();
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 3:
                    this.susConsult.lowSuspicious();
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 4:

                    break;

                default:
                    System.out.println("Opcion Invalidad");
                    break;
            }
        } while (opcion != 4);
    }

    public void generalInfectionMenuRun() {
        int opcion;
        do {

            System.out.println("1. Ver arbol de infecciones");
            System.out.println("2. Ver personas infectadas");

            System.out.println("3. Salir");

            System.out.print("Digite su opcion: ");
            try {

                opcion = scanner.nextInt();

            } catch (InputMismatchException e) {
                opcion = 0;
                System.out.println("Entrada invalida.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    this.infConsult.infectorTree();
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();
                    scanner.nextLine();

                    break;
                case 2:
                    this.infConsult.infected();
                    System.out.println("\n\n Digite cualquier tecla para continuar");

                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 3:

                    break;

                default:
                    System.out.println("Opcion Invalidad");
                    break;
            }
        } while (opcion != 3);
    }

    public void vacinneMenuRun() {
        int opcion;
        do {

            System.out.println("1. Consultas por pacientes");
            System.out.println("2. Consultas generales");
            System.out.println("3. Salir");

            System.out.print("Digite su opcion: ");

            try {

                opcion = scanner.nextInt();

            } catch (InputMismatchException e) {
                opcion = 0;
                System.out.println("Entrada invalida.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:

                    this.pacientVaccineMenuRun();

                    break;
                case 2:
                    this.generalVaccineMenuRun();

                    break;
                case 3:

                    break;

                default:
                    System.out.println("Opcion Invalida");
                    break;
            }
        } while (opcion != 3);
    }

    public void infectionMenuRun() {
        int opcion;
        do {

            System.out.println("1. Consultas por pacientes");
            System.out.println("2. Consultas generales");
            System.out.println("3. Salir");

            System.out.print("Digite su opcion: ");

            try {

                opcion = scanner.nextInt();

            } catch (InputMismatchException e) {
                opcion = 0;
                System.out.println("Entrada invalida.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:

                    this.pacientInfectionMenuRun();

                    break;
                case 2:
                    this.generalInfectionMenuRun();

                    break;
                case 3:

                    break;

                default:
                    System.out.println("Opcion Invalidad");
                    break;
            }
        } while (opcion != 3);
    }

    public void suspicionMenuRun() {
        int opcion;
        do {

            System.out.println("1. Consultas por pacientes");
            System.out.println("2. Consultas generales");
            System.out.println("3. Salir");


            System.out.print("Digite su opcion: ");

            try {

                opcion = scanner.nextInt();

            } catch (InputMismatchException e) {
                opcion = 0;
                System.out.println("Entrada invalida.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:

                    this.pacientSuspicionMenuRun();

                    break;
                case 2:
                    this.generalSuspicionMenuRun();

                    break;
                case 3:

                    break;

                default:
                    System.out.println("Opcion Invalidad");
                    break;
            }
        } while (opcion != 3);
    }

    public void symptomsMenuRun() {
        int opcion;
        do {

            System.out.println("1. Consultas por pacientes");
            System.out.println("2. Consultas generales");
            System.out.println("3. Salir");

            System.out.print("Digite su opcion: ");

            try {

                opcion = scanner.nextInt();

            } catch (InputMismatchException e) {
                opcion = 0;
                System.out.println("Entrada invalida.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:

                    this.pacientSymptomsMenuRun();

                    break;
                case 2:
                    this.generalSymptomsMenuRun();

                    break;
                case 3:

                    break;

                default:
                    System.out.println("Opcion Invalidad");
                    break;
            }
        } while (opcion != 3);
    }

    public void riskMenuRun() {
        int opcion;
        do {

            System.out.println("1. Consultas por pacientes");
            System.out.println("2. Consultas generales");
            System.out.println("3. Salir");

            System.out.print("Digite su opcion: ");

            try {

                opcion = scanner.nextInt();

            } catch (InputMismatchException e) {
                opcion = 0;
                System.out.println("Entrada invalida.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:

                    this.pacientRiskMenuRun();

                    break;
                case 2:
                    this.generalRiskMenuRun();

                    break;
                case 3:

                    break;

                default:
                    System.out.println("Opcion Invalidad");
                    break;
            }
        } while (opcion != 3);
    }

    public void conditionMenuRun() {
        int opcion;
        do {

            System.out.println("1. Consultas por pacientes");
            System.out.println("2. Consultas generales");
             System.out.println("3. Salir");

            System.out.print("Digite su opcion: ");

            try {

                opcion = scanner.nextInt();

            } catch (InputMismatchException e) {
                opcion = 0;
                System.out.println("Entrada invalida.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:

                    this.pacientConditionMenuRun();

                    break;
                case 2:
                    this.generalConditionMenuRun();

                    break;
                case 3:

                    break;

                default:
                    System.out.println("Opcion Invalidad");
                    break;
            }
        } while (opcion != 3);
    }

    public void run() {
        int opcion;
        do {

            System.out.println("1. Consultas de vacuna");
            System.out.println("2. Consultas infecciones");
            System.out.println("3. Consultas de sospechas");
            System.out.println("4. Consultas de condiciones");
            System.out.println("5. Consultas de sintomas");
            System.out.println("6. Consultas de riesgos");
            System.out.println("7. Salir");

            System.out.print("Digite su opcion: ");

            try {

                opcion = scanner.nextInt();

            } catch (InputMismatchException e) {
                opcion = 0;
                System.out.println("Entrada invalida.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    this.vacinneMenuRun();

                    break;
                case 2:
                    this.infectionMenuRun();

                    break;
                case 3:
                    this.suspicionMenuRun();

                    break;
                case 4:
                    this.conditionMenuRun();
                    break;
                case 5:
                    this.symptomsMenuRun();
                    break;
                case 6:
                    this.riskMenuRun();
                    break;
                case 7:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion Invalidad");
                    break;
            }
        } while (opcion != 7);
    }

}
