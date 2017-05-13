# Endpoints - URLS

### /films
```
Method: GET
Description: Returns list of all movies from the application.
Example: {
  "film": [
    {
      "id": "0",
      "name": "Matrix"
    },
    {
      "id": "1",
      "name": "Titanic"
    },
    {
      "id": "2",
      "name": "Avatar"
    }
  ]
}
```
 
### /films
```
Method: POST
Input format: { "name": "Movie name" }
Description: Creates and returns new movie.
Example:
{
	"name" : "Test Movie"
}
```

### /films/{id}
```
Method: POST
Input format: { "name": "Updated movie name" }
Description: Updates and returns updated movie with specified id.
Example:
{
  "id": "1",
  "name": "Titanic"
}
```

### /films/{id}/actors
```
Method: GET
Description: Returns list of all actors of movie with specified id.
Example:
{
  "actor": {
    "id": "2",
    "name": "Leonardo DiCaprio"
  }
}
```

### /films/{id}/comments
```
Method: GET
Description: Returns list of all comments of movie with specified id.
Example:
{
  "comment": [
    {
      "id": "2"
    },
    {
      "id": "1"
    },
    {
      "id": "0"
    }
  ]
}
```

### /films/{id}/comments
```
Method: POST
Input format: { "text": "Comment" }
Description: Creates new comment for specified movie and returns it.
Example:
{
  "comment": "New Comment"
}
```

### /films/{id}/rate/{rating}
```
Method: POST
Input format: Body is not required.
Description: Updates rating of the movie and returns this movie (rating should be integer number).
Example:

Url: /films/{id}
Method: GET
Description: Returns movie with specified ID.
Example:
{
  "id": "1",
  "name": "Titanic"
}
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
Example:
{
  "actor": [
    {
      "id": "0",
      "name": "Keanu Reeves"
    },
    {
      "id": "1",
      "name": "Laurence Fishburne"
    },
    {
      "id": "2",
      "name": "Leonardo DiCaprio"
    },
    {
      "id": "3",
      "name": "Sigourney Weaver"
    }
}
```

### /actors/{id}
```
Method: GET
Description: Returns actor with specified id from the application.
Example:
{
  "id": "2",
  "name": "Leonardo DiCaprio"
}
```

### /actors/{id}/films
```
Method: GET
Description: Returns all films of specified actor.
Example: 
{
  "film": {
    "id": "1",
    "name": "Titanic"
  }
}
```

### /actors
```
Method: POST
Input format: { "name": "Actor name" }
Description: Creates and returns new actor.
Example:
{
  "name": "New Actor"
}
```

### /actors/{actorId}/assign-to-film/{filmId}
```
Method: POST
Input format: Body is not required.
Description: Connects specified actor with specified film.
Example: {
  "actor": {
    "id": "2",
    "name": "Leonardo DiCaprio"
  }
}
```
