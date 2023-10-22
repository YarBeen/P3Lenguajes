/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pl3.p3lenguajes;
import java.util.Scanner;
import com.pl3.p3lenguajes.Consulters.conditionsConsulter;
import com.pl3.p3lenguajes.Consulters.infectionConsulter;
import com.pl3.p3lenguajes.Consulters.suspicionConsulter;
import com.pl3.p3lenguajes.Consulters.vaccinesConsulter;

/**
 *
 * @author Yarman
 */
public class menuRunner {
    private conditionsConsulter condConsult;
    private infectionConsulter infConsult;
    private suspicionConsulter susConsult;
    private vaccinesConsulter vacConsult;
    private Scanner scanner;
    public menuRunner(Scanner scanner){
        this.condConsult= new conditionsConsulter();
        this.infConsult = new infectionConsulter();
        this.susConsult = new suspicionConsulter();
        this.vacConsult = new vaccinesConsulter();
        this.scanner = scanner;
        
    }
    public void run(){
        int opcion;
        do {
            
            System.out.println("1. Consultas por pacientes");
            System.out.println("2. Consultas generales");
            
            System.out.print("Digite su opcion: ");

            opcion = this.scanner.nextInt();

            switch (opcion) {
                case 1:
                    
                    System.out.println("You selected Option 1");

                    break;
                case 2:
                    System.out.println("You selected Option 2");

                    break;
                case 3:
                    System.out.println("You selected Option 3");

                    break;
                case 4:
                    System.out.println("Exiting the program");
                    break;
                case 5:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion Invalidad2");
                    break;
            }
        } while (opcion != 5);
    }
    
}
