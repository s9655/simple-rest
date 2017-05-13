package com.cinema.store;

import com.cinema.model.Film;

import java.util.ArrayList;
import java.util.List;

/**
 * Store for all information about cinema - movies, actors, etc.
 */
public class Cinema {

    private static Cinema cinema = new Cinema();

    private Long lastFilmId = 0L;

    private List<Film> films = new ArrayList<>();

    public static Cinema getInstance() {
        return cinema;
    }

    public Film addFilm(Film film) {
        films.add(film);
        film.setId(lastFilmId++);
        return film;
    }

    public List<Film> getFilms() {
        return films;
    }
}
