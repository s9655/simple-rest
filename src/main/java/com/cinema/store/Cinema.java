package com.cinema.store;

import com.cinema.model.Actor;
import com.cinema.model.Comment;
import com.cinema.model.Film;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Store for all information about cinema - movies, actors, etc.
 */
public class Cinema {

    private static Cinema cinema = new Cinema();

    private Long lastFilmId = 0L;

    private Long lastActorId = 0L;

    private Long lastCommentId = 0L;

    private List<Film> films = new ArrayList<>();

    private List<Actor> actors = new ArrayList<>();

    private List<Comment> comments = new ArrayList<>();

    private Map<Long, List<Integer>> filmRatings = new HashMap<>();

    private Cinema() {
        Film film = new Film();
        film.setName("Matrix");
        addFilm(film);
        film = new Film();
        film.setName("Titanic");
        addFilm(film);
        film = new Film();
        film.setName("Avatar");
        addFilm(film);
        Actor actor = new Actor();
        actor.setName("Keanu Reeves");
        addActor(actor);
        actor = new Actor();
        actor.setName("Laurence Fishburne");
        addActor(actor);
        actor = new Actor();
        actor.setName("Leonardo DiCaprio");
        addActor(actor);
        actor = new Actor();
        actor.setName("Sigourney Weaver");
        addActor(actor);
        assignActorToFilm(0L, 0L);
        assignActorToFilm(1L, 0L);
        assignActorToFilm(2L, 1L);
        assignActorToFilm(3L, 2L);

    }

    public static Cinema getInstance() {
        return cinema;
    }

    public Film rateFilm(Long filmId, int rating) {
        List<Integer> ratings = filmRatings.computeIfAbsent(filmId, k -> new ArrayList<>());
        ratings.add(rating);
        double newRating = ratings.stream()
                .mapToDouble(a -> a)
                .average().getAsDouble();
        Film film = getFilmById(filmId);
        film.setRating(newRating);
        return film;
    }

    public Film addFilm(Film film) {
        films.add(film);
        film.setId(lastFilmId++);
        return film;
    }

    public Comment addComment(Comment comment, Long filmId) {
        Film film = getFilmById(filmId);
        film.getComments().add(comment);
        comment.setId(lastCommentId++);
        return comment;
    }

    public void deleteComment(Long id) {
        comments.removeIf(comment -> comment.getId().equals(id));
        films.forEach(film -> film.getComments()
                .removeIf(comment -> comment.getId().equals(id)));
    }

    public List<Film> getFilms() {
        return films;
    }

    public Film getFilmById(Long id) {
        return films.stream()
                .filter(film -> film.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public Actor getActorById(Long id) {
        return actors.stream()
                .filter(actor -> actor.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public Actor assignActorToFilm(Long actorId, Long filmId) {
        Actor actor = getActorById(actorId);
        Film film = getFilmById(filmId);
        actor.getFilms().add(film);
        return actor;
    }

    public Actor addActor(Actor actor) {
        actors.add(actor);
        actor.setId(lastActorId++);
        return actor;
    }

    public List<Actor> getActors() {
        return actors;
    }
}
