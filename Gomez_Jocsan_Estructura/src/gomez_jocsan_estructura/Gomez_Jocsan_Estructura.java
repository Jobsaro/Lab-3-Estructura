/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gomez_jocsan_estructura;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Gomez_Jocsan_Estructura {

    public static final String BLACK = "\u001B[30m";    // Negro
    public static final String YELLOW = "\u001B[33m";   // Amarillo
    public static final String BLUE = "\u001B[34m";     // Azul
    public static final String RED = "\u001B[31m";      // Rojo
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // variables para la condicpon
        int PalabraAlreves = 0;
        int NumeroPerfecto = 0;
        int Primos = 0;
        int Votaciones = 0;
        int opcion;//esta variable detecta la opcion elegida

        do {
            // Menu principal
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1 - Palabra Alreves");
            System.out.println("2 - Numero Perfecto");
            System.out.println("3 - Primos");
            System.out.println("4 - Votaciones");
            System.out.println("5 - Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                // Opcion 1 palabra al revez
                PalabraAlreves++;//aumenta el contador
                System.out.print("Ingrese una palabra: ");
                String palabra = scanner.nextLine();
                String alReves = "";
                
                //invertir la palabra escrita
                for (int i = palabra.length() - 1; i >= 0; i--) {
                    alReves += palabra.charAt(i);
                }
                System.out.println("Palabra al reves: " + alReves);

            } else if (opcion == 2) {
                // Opcion 2 numero perfecto
                NumeroPerfecto++;//aumenta el contador
                System.out.print("Ingrese un numero: ");
                int numero = scanner.nextInt();
                int sumaDivisores = 0;
                
                //calcula los divisores del numero
                for (int i = 1; i < numero; i++) {
                    if (numero % i == 0) {
                        sumaDivisores += i;
                    }
                }
                
                //verificar si la suma coinside con el numero ingresado
                if (sumaDivisores == numero) {
                    System.out.println(numero + " es un numero perfecto.");
                } 
                else {
                    System.out.println(numero + " no es un numero perfecto.");
                }

            } else if (opcion == 3) {
                // Opción 3 numerows primos
                Primos++;
                int numeroAleatorio = random.nextInt(100) + 1;//genera el numero aleatorio
                System.out.println("Numero aleatorio generado: " + numeroAleatorio);
                boolean Primo = true;
                String divisores = "1";//almacena los divisores

                //encuentra los divisores y si es primo
                for (int i = 2; i <= numeroAleatorio; i++) {
                    if (numeroAleatorio % i == 0) {
                        divisores += ", " + i;
                        if (i != numeroAleatorio) {
                            Primo = false;
                        }
                    }
                }

                //muestra el resultado si es primo o no
                if (Primo) {
                    System.out.println(numeroAleatorio + " es primo porque solo tiene dos divisores.");
                } else {
                    System.out.println(numeroAleatorio + " no es primo.");
                }
                System.out.println("Divisores de " + numeroAleatorio + " son: " + divisores);

            } else if (opcion == 4) {
                // Opcion 4 votaciones
                Votaciones++;
                System.out.print("Ingrese la cantidad de votantes: ");
                int votantes = scanner.nextInt();
                scanner.nextLine(); 
                
                //variables que contaran los votos
                int votosAzul = 0;
                int votosRojo = 0;
                int votosNegro = 0;
                int votosAmarillo = 0;
                int votoNulos = 0;

                //recolecta los votos
                for (int i = 0; i < votantes; i++) {
                    System.out.print("Ingrese su voto (AZUL, ROJO, NEGRO, AMARILLO): ");
                    String voto = scanner.nextLine().toUpperCase();

                    //cuenta cada tipo de voto
                    if (voto.equals("AZUL")) {
                        votosAzul++;
                    } else if (voto.equals("ROJO")) {
                        votosRojo++;
                    } else if (voto.equals("NEGRO")) {
                        votosNegro++;
                    } else if (voto.equals("AMARILLO")) {
                        votosAmarillo++;
                    } else {
                        votoNulos++;//incrementa si el numero no es valido
                    }
                }

                //verifica si los votos llegan al 60% 
                int votosValidos = votosAzul + votosRojo + votosNegro + votosAmarillo;
                if (votosValidos >= votantes * 0.6) {
                    if (votosAzul > votosRojo && votosAzul > votosNegro && votosAzul > votosAmarillo) {
                        System.out.println(BLUE+"La planilla ganadora es AZUL.");
                    } else if (votosRojo > votosAzul && votosRojo > votosNegro && votosRojo > votosAmarillo) {
                        System.out.println(RED+"La planilla ganadora es ROJO.");
                    } else if (votosNegro > votosAzul && votosNegro > votosRojo && votosNegro > votosAmarillo) {
                        System.out.println(BLACK+"La planilla ganadora es NEGRO.");
                    } else if (votosAmarillo > votosAzul && votosAmarillo > votosRojo && votosAmarillo > votosNegro) {
                        System.out.println(YELLOW+"La planilla ganadora es AMARILLO.");
                    }
                } else {
                    System.out.println("VOTACIÓN FALLIDA");
                }

            } else if (opcion == 5) {
                // Opcion 5 Salir
                System.out.println("Saliendo del programa...");
                System.out.println("Veces que se ingresó a cada opción:");
                System.out.println("Palabra Alreves: " + PalabraAlreves);
                System.out.println("Número Perfecto: " + NumeroPerfecto);
                System.out.println("Primos: " + Primos);
                System.out.println("Votaciones: " + Votaciones);
            } else {
                System.out.println("Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 5);//para repetir el menu infinitamente
    }
}