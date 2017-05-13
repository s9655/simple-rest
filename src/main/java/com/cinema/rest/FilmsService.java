package com.cinema.rest;

import com.cinema.model.Actor;
import com.cinema.model.Comment;
import com.cinema.model.Film;
import com.cinema.store.Cinema;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Rest service for working with movies.
 */
@Path("/films")
public class FilmsService {

    private Cinema cinema = Cinema.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Film> getFilms() {
        return cinema.getFilms();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Film addFilm(Film film) {
        return cinema.addFilm(film);
    }

    @POST
    @Path(("/{id}"))
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Film updateFilm(@PathParam("id") Long id, Film updatedFilm) {
        Film storedFilm = cinema.getFilmById(id);
        storedFilm.setName(updatedFilm.getName());
        return storedFilm;
    }

    @GET
    @Path(("/{id}/actors"))
    @Produces(MediaType.APPLICATION_JSON)
    public List<Actor> getFilmActorsById(@PathParam("id") Long id) {
        return cinema.getActors().stream()
                .filter(actor -> actor.getFilms().stream().anyMatch(film -> film.getId().equals(id)))
                .collect(Collectors.toList());
    }

    @GET
    @Path(("/{id}/comments"))
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Comment> getFilmCommentsById(@PathParam("id") Long id) {
        return cinema.getFilmById(id).getComments();
    }

    @POST
    @Path(("/{id}/comments"))
    @Produces(MediaType.APPLICATION_JSON)
    public Comment getFilmActorsById(Comment comment, @PathParam("id") Long id) {
        return cinema.addComment(comment, id);
    }

    @POST
    @Path(("/{id}/rate/{rating}"))
    @Produces(MediaType.APPLICATION_JSON)
    public Film getFilmActorsById(@PathParam("id") Long filmId,
                                    @PathParam("rating") int rating) {
        return cinema.rateFilm(filmId, rating);
    }

    @GET
    @Path(("/{id}"))
    @Produces(MediaType.APPLICATION_JSON)
    public Film getFilmById(@PathParam("id") Long id) {
        return cinema.getFilmById(id);
    }
}
