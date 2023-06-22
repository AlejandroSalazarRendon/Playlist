package main;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    
    
    //Main
    public static void main(String[] args) {
        int option;
        
        do {
            displayMainMenu();
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    //libraryMenu();
                    break;
                case 2:
                    //playlistMenu();
                    break;
                case 3:
                    //filterMenu();
                    break;
                case 4:
                    //sortMenu();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Introduce un número del 1 al 5.");
                    break;
            }
        } while (option != 5);
    }

    //Mostrar el menú 
    private static void displayMainMenu() {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("----- Menú Principal -----");
        System.out.println("1. Mostrar biblioteca");
        System.out.println("2. Crear una playlist");
        System.out.println("3. Filtrar canciones");
        System.out.println("4. Ordenar");
        System.out.println("5. Salir");
        System.out.print("Elige una opción: ");
    }
}
