package main;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String nombre;
    private List<Song> songs;

    public Playlist(String nombre) {
        this.nombre = nombre;
        songs = new ArrayList<>();
    }

    public void addSong(Song cancion) {
        songs.add(cancion);
        System.out.println("Canción agregada a la playlist.");
    }

    public void removeSong(int identificador) {
        for (Song cancion : songs) {
            if (cancion.getIdentifier() == identificador) {
                songs.remove(cancion);
                System.out.println("Canción eliminada de la playlist.");
                return;
            }
        }
        System.out.println("No se encontró ninguna canción con el identificador proporcionado en la playlist.");
    }

    public void showSongs() {
        if (songs.isEmpty()) {
            System.out.println("La playlist está vacía.");
        } else {
            System.out.println("Canciones en la playlist " + nombre + ":");
            for (Song cancion : songs) {
                System.out.println("- " + cancion.getTitle());
            }
        }
    }
}
