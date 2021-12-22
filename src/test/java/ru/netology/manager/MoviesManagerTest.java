package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MoviesManagerTest {

    @Test
    void shouldSaveMovie() {
        Movie first = new Movie();
        Movie second = new Movie();
        Movie third = new Movie();

        MoviesManager manager = new MoviesManager();
        manager.save(first);
        manager.save(second);
        manager.save(third);

        Movie[] expected = {first, second, third};
        Movie[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddMovie() {
        Movie first = new Movie();
        Movie second = new Movie();
        Movie third = new Movie();

        MoviesManager manager = new MoviesManager();
        manager.save(first);
        manager.save(second);
        manager.add(third);

        Movie[] expected = {first, second, third};
        Movie[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetLastMovie() {
        Movie first = new Movie();
        Movie second = new Movie();
        Movie third = new Movie();
        Movie fourth = new Movie();
        Movie fifth = new Movie();
        Movie sixth = new Movie();
        Movie seventh = new Movie();
        Movie eighth = new Movie();
        Movie ninth = new Movie();
        Movie tenth = new Movie();
        Movie eleventh = new Movie();

        MoviesManager manager = new MoviesManager();
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eighth);
        manager.save(ninth);
        manager.save(tenth);
        manager.save(eleventh);
        manager.getMovie();

        Movie[] expected = { eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second };
        Movie[] actual = manager.getMovie();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetLessLastMovie() {
        Movie first = new Movie();
        Movie second = new Movie();
        Movie third = new Movie();
        Movie fourth = new Movie();
        Movie fifth = new Movie();


        MoviesManager manager = new MoviesManager();
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.getMovie();

        Movie[] expected = { fifth, fourth, third, second, first };
        Movie[] actual = manager.getMovie();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetOneLastMovie() {
        Movie first = new Movie();

        MoviesManager manager = new MoviesManager();
        manager.save(first);
        manager.getMovie();

        Movie[] expected = { first };
        Movie[] actual = manager.getMovie();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetEmptyList() {
        MoviesManager manager = new MoviesManager();
        manager.getMovie();

        Movie[] expected = {};
        Movie[] actual = manager.getMovie();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetLastMovieWithParameter() {
        Movie first = new Movie();
        Movie second = new Movie();
        Movie third = new Movie();
        Movie fourth = new Movie();
        Movie fifth = new Movie();


        MoviesManager manager = new MoviesManager(5);
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.getMovie();

        Movie[] expected = { fifth, fourth, third, second, first };
        Movie[] actual = manager.getMovie();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetLessLastMovieWithParameter() {
        Movie first = new Movie();
        Movie second = new Movie();
        Movie third = new Movie();
        Movie fourth = new Movie();
        Movie fifth = new Movie();


        MoviesManager manager = new MoviesManager(3);
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.getMovie();

        Movie[] expected = { fifth, fourth, third };
        Movie[] actual = manager.getMovie();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetEmptyListWithParameter() {
        MoviesManager manager = new MoviesManager(5);
        manager.getMovie();

        Movie[] expected = {};
        Movie[] actual = manager.getMovie();

        assertArrayEquals(expected, actual);
    }
}