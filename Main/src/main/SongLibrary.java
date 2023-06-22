package main;

import java.util.ArrayList;
import java.util.List;

public class SongLibrary {
    private List<Song> Songs;

    public SongLibrary() {
        Songs = new ArrayList<>();
    }

    public List<Song> getSongs() {
        return Songs;
    }

    public void setSongs(List<Song> canciones) {
        this.Songs = canciones;
    }
    
    

    public void addSong(Song cancion) {
        Songs.add(cancion);
        System.out.println("Canción agregada a la biblioteca.");
    }

    public void removeSong(int identificador) {
        for (Song cancion : Songs) {
            if (cancion.getIdentifier() == identificador) {
                Songs.remove(cancion);
                System.out.println("Canción eliminada de la biblioteca.");
                return;
            }
        }
        System.out.println("No se encontró ninguna canción con el identificador proporcionado.");
    }

    public void displayAllSongs() {
        if (Songs.isEmpty()) {
            System.out.println("La biblioteca está vacía.");
        } else {
            System.out.println("Canciones en la biblioteca:");
            for (Song cancion : Songs) {
                System.out.println("- " + cancion.getTitle());
            }
        }
    }

    public void playSongs() {
        if (Songs.isEmpty()) {
            System.out.println("No hay canciones en la biblioteca para reproducir.");
        } else {
            System.out.println("Reproduciendo canciones:");
            for (Song cancion : Songs) {
                System.out.println("Reproduciendo: " + cancion.getTitle());
                try {
                    Thread.sleep(10000); // Pausa de 10 segundos entre Songs
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Fin de la reproducción.");
        }
    }
}
