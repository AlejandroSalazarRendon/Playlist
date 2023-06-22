package main;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class Song {
    private String title;
    private int identifier;
    private LocalDate date;
    private int duration;
    private String gender;
    private String cover;
    private String description;

    // Constructor
    public Song(String titulo, int identificador, LocalDate fecha, int duracion, String genero, String caratula, String descripcion) {
        this.title = titulo;
        this.identifier = identificador;
        this.date = fecha;
        this.duration = duracion;
        this.gender = genero;
        this.cover = caratula;
        this.description = descripcion;
    }

    // Getters y setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

    // Método para mostrar los detalles de la canción
    public void showDetails() {
        System.out.println("Título: " + title);
        System.out.println("Identificador: " + identifier);
        System.out.println("Fecha: " + date);
        System.out.println("Duración: " + duration + " segundos");
        System.out.println("Género: " + gender);
        System.out.println("Carátula: " + cover);
        System.out.println("Descripción: " + description);
    }
}
