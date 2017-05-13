package com.cinema.rest;

import com.cinema.store.Cinema;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST service for working with comments for films.
 */
@Path("/comments")
public class CommentsService {

    private Cinema cinema = Cinema.getInstance();

    @DELETE
    @Path(("/{id}"))
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCommentById(@PathParam("id") Long id) {
        cinema.deleteComment(id);
    }
}
