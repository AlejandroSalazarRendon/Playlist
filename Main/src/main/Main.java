package main;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static SongLibrary library = new SongLibrary();
    private static Playlist playlist;
    
    //Main
    public static void main(String[] args) {
        int option;
        
        do {
            displayMainMenu();
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    libraryMenu();
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
    
    //Menú  que muestra la librería de canciones
        private static void libraryMenu() {
        int option;

        do {
            System.out.println("");
            System.out.println("");
            System.out.println("----- Submenú Biblioteca -----");
            System.out.println("1. Mostrar todas las canciones");
            System.out.println("2. Agregar una canción");
            System.out.println("3. Eliminar una canción");
            System.out.println("4. Reproducir canciones");
            System.out.println("5. Volver al menú principal");
            System.out.print("Elige una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    library.displayAllSongs();
                    break;
                case 2:
                    addSongToLibrary();
                    break;
                case 3:
                    removeSongFromLibrary();
                    break;
                case 4:
                    library.playSongs();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Introduce un número del 1 al 5.");
                    break;
            }
        } while (option != 5);
    }
    
    //Agregar una canción a la librería
    private static void addSongToLibrary() {

        System.out.print("Ingrese el título de la canción: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el identificador de la canción: ");
        int identificador = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la fecha de la canción (AAAA-MM-DD): ");
        String fechaStr = scanner.nextLine();
        LocalDate fecha = LocalDate.parse(fechaStr);
        System.out.print("Ingrese la duración de la canción en segundos: ");
        int duracion = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Ingrese el género de la canción: ");
        String genero = scanner.nextLine();
        System.out.print("Ingrese la carátula de la canción: ");
        String caratula = scanner.nextLine();
        System.out.print("Ingrese una descripción corta de la canción: ");
        String descripcion = scanner.nextLine();

        Song cancion = new Song(titulo, identificador, fecha, duracion, genero, caratula, descripcion);
        library.addSong(cancion);
    }
    
    //elimina una canción de la  librería
    private static void removeSongFromLibrary() {

        System.out.print("Ingrese el identificador de la canción a eliminar: ");
        int identificador = scanner.nextInt();
        library.removeSong(identificador);
    }
    
    //Menu para Playlist 
    private static void playlistMenu() {
        int option;

        do {
            System.out.println("");
            System.out.println("");
            System.out.println("----- Submenú Playlist -----");
            System.out.println("1. Crear una playlist");
            System.out.println("2. Eliminar una playlist");
            System.out.println("3. Mostrar playlists");
            System.out.println("4. Agregar canciones a una playlist");
            System.out.println("5. Eliminar canciones de una playlist");
            System.out.println("6. Volver al menú principal");
            System.out.print("Elige una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                    //createAPlaylist();
                    break;
                case 2:
                    //removeAPlaylist();
                    break;
                case 3:
                    //showPlaylist();
                    break;
                case 4:
                   // addSongsToPlaylist();
                    break;
                case 5:
                    //removeSongsFromPlaylist();
                    break;
                case 6:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Introduce un número del 1 al 6.");
                    break;
            }
        }while(option!=6);
    }
}
