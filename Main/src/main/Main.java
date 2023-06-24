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
                    playlistMenu();
                    break;
                case 3:
                    filterMenu();
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
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    createAPlaylist();
                    break;
                case 2:
                    removeAPlaylist();
                    break;
                case 3:
                    showPlaylist();
                    break;
                case 4:
                    addSongsToPlaylist();
                    break;
                case 5:
                    removeSongsFromPlaylist();
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
    
    //Metodo que crea una playlist
    private static void createAPlaylist() {
        System.out.print("Ingrese el nombre de la playlist: ");
        String nombre = scanner.nextLine();
        playlist = new Playlist(nombre);
        System.out.println("Playlist creada.");
    }

    //Metodo que elimina una playlist
    private static void removeAPlaylist() {
        if (playlist != null) {
            playlist = null;
            System.out.println("Playlist eliminada.");
        } else {
            System.out.println("No hay ninguna playlist creada.");
        }
    }

    //Metodo que muestra la playlist
    private static void showPlaylist() {
        if (playlist != null) {
            playlist.showSongs();
        } else {
            System.out.println("No hay ninguna playlist creada.");
        }
    }
    
        // Añadir una canción a la playlist
        private static void addSongsToPlaylist() {
        if (playlist != null) {
            System.out.print("Ingrese el identificador de la canción a agregar a la playlist: ");
            int identificador = scanner.nextInt();
            scanner.nextLine();

            for (Song cancion : library.getSongs()) {
                if (cancion.getIdentifier() == identificador) {
                    playlist.addSong(cancion);
                    return;
                }
            }

            System.out.println("No se encontró ninguna canción con el identificador proporcionado en la biblioteca.");
        } else {
            System.out.println("No hay ninguna playlist creada.");
        }
    }

        //Eliminar una cancion de la playlist
    private static void removeSongsFromPlaylist() {
        if (playlist != null) {
            System.out.print("Ingrese el identificador de la canción a eliminar de la playlist: ");
            int identificador = scanner.nextInt();
            scanner.nextLine(); 
            playlist.removeSong(identificador);
        } else {
            System.out.println("No hay ninguna playlist creada.");
        }
    }

    //Menu para filtrar por genero o por año
    private static void filterMenu() {
        int option;

        do {
            System.out.println("");
            System.out.println("");
            System.out.println("----- Submenú Filtrar Canciones -----");
            System.out.println("1. Filtrar canciones por año");
            System.out.println("2. Filtrar canciones por género");
            System.out.println("3. Volver al menú principal");
            System.out.print("Elige una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    filterByYear();
                    break;
                case 2:
                    filterByGender();
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Introduce un número del 1 al 3.");
                    break;
            }
        } while (option != 3);
    }

    //filtración por año
    private static void filterByYear() {
        System.out.print("Ingrese el año: ");
        int anio = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.println("Canciones del año " + anio + ":");

        for (Song cancion : library.getSongs()) {
            if (cancion.getDate().getYear() == anio) {
                System.out.println("- " + cancion.getTitle());
            }
        }
    }

    //filtracion por genero
    private static void filterByGender() {
        System.out.print("Ingrese el género: ");
        String genero = scanner.nextLine();

        System.out.println("Canciones del género " + genero + ":");

        for (Song cancion : library.getSongs()) {
            if (cancion.getGender().equalsIgnoreCase(genero)) {
                System.out.println("- " + cancion.getTitle());
            }
        }
    }
}
