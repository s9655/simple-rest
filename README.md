# Endpoints - URLS

### /films
```
Method: GET
Description: Returns list of all movies from the application.
```
 
### /films
```
Method: POST
Input format: { "name": "Movie name" }
Description: Creates and returns new movie.
```

### /films/{id}
```
Method: POST
Input format: { "name": "Updated movie name" }
Description: Updates and returns updated movie with specified id.
```

### /films/{id}/actors
```
Method: GET
Description: Returns list of all actors of movie with specified id.
```

### /films/{id}/comments
```
Method: GET
Description: Returns list of all comments of movie with specified id.
```

### /films/{id}/comments
```
Method: POST
Input format: { "text": "Comment" }
Description: Creates new comment for specified movie and returns it.
```

### /films/{id}/rate/{rating}
```
Method: POST
Input format: Body is not required.
Description: Updates rating of the movie and returns this movie (rating should be integer number).
```

### /films/{id}
```
Method: GET
Description: Returns movie with specified ID.
```

### /comments/{id}
```
Method: DELETE
Description: Removes comment with specified ID.
```

### /actors
```
Method: GET
Description: Returns all actors from the application.
```

### /actors/{id}
```
Method: GET
Description: Returns actor with specified id from the application.
```

### /actors/{id}/films
```
Method: GET
Description: Returns all films of specified actor.
```

### /actors
```
Method: POST
Input format: { "name": "Actor name" }
Description: Creates and returns new actor.
```

### /actors/{actorId}/assign-to-film/{filmId}
```
Method: POST
Input format: Body is not required.
Description: Connects specified actor with specified film.
```
