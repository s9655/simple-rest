package com.cinema.rest;

import com.cinema.model.Actor;
import com.cinema.model.Film;
import com.cinema.store.Cinema;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;

/**
 * REST service for working with actors.
 */
@Path("/actors")
public class ActorsService {

    private Cinema cinema = Cinema.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Actor> getActors() {
        return cinema.getActors();
    }

    @GET
    @Path(("/{id}"))
    @Produces(MediaType.APPLICATION_JSON)
    public Actor getActorById(@PathParam("id") Long id) {
        return cinema.getActorById(id);
    }

    @GET
    @Path(("/{id}/films"))
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Film> getActorFilmsById(@PathParam("id") Long id) {
        return cinema.getActorById(id).getFilms();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Actor addActor(Actor actor) {
        return cinema.addActor(actor);
    }

    @POST
    @Path("/{actorId}/assign-to-film/{filmId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Actor addActor(@PathParam("actorId") Long actorId,
                          @PathParam("filmId") Long filmId) {
        return cinema.assignActorToFilm(actorId, filmId);
    }
}
