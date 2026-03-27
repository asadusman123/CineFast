package com.example.cinefast2_23l_0740;

public class Movie {

    String name;
    String genre;
    int image;

    public Movie(String name, String genre, int image) {
        this.name = name;
        this.genre = genre;
        this.image = image;
    }

    public String getName() { return name; }
    public String getGenre() { return genre; }
    public int getImage() { return image; }
}