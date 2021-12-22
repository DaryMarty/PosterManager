package ru.netology.manager;

import ru.netology.domain.Movie;

public class MoviesManager {

    private Movie[] movies = new Movie[0];
    private int lastAddedMovies = 10;


    public MoviesManager(int lastAddedMovies) {
        this.lastAddedMovies = lastAddedMovies;
    }

    public MoviesManager() {
    }

    public int getLastAddedMovies() {
        return lastAddedMovies;
    }

    public void setLastAddedMovies(int lastAddedMovies) {
        this.lastAddedMovies = lastAddedMovies;
    }


    public void save (Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public void add(Movie movie) {save(movie);}

    public Movie[] findAll() {return movies;}

    public Movie[] getMovie() {
        Movie[] movies = findAll();
        int resultLength = movies.length;
        if (movies.length > this.lastAddedMovies) {
            resultLength = this.lastAddedMovies;
        } else {
            resultLength = movies.length;
        }
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}
