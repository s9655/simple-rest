package com.cinema.rest;

import com.cinema.model.Film;
import com.cinema.store.Cinema;

import javax.ws.rs.*;
import java.util.List;

/**
 * Rest service for working with movies.
 */
@Path("/films")
public class FilmsService {

    private Cinema cinema = Cinema.getInstance();

    @GET
    public List<Film> getFilms() {
        return cinema.getFilms();
    }

    @POST
    public Film addFilm(Film film) {
        return cinema.addFilm(film);
    }

    @POST
    @Path(("/{id}"))
    public Film updateFilm(@PathParam("id") Long id, Film updatedFilm) {
        Film storedFilm = cinema.getFilms().stream()
                .filter(it -> it.getId().equals(id))
                .findAny()
                .get();
        storedFilm.setName(updatedFilm.getName());
        return storedFilm;
    }

    @DELETE
    @Path(("/{id}"))
    public List<Film> deleteFilm(@PathParam("id") Long id) {
        cinema.getFilms().removeIf(film -> film.getId().equals(id));
        return cinema.getFilms()cd ;
    }

    @GET
    @Path(("/{id}"))
    public Film getFilmById(@PathParam("id") Long id) {
        return cinema.getFilms().stream()
                .filter(film -> film.getId().equals(id))
                .findAny().orElse(new Film());
    }
}
