package de.hec.movie;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import de.hec.movie.finder.MovieJsonFinder;
import de.hec.movie.model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MovieJsonFinderTest {

    private MovieJsonFinder movieJsonFinder;

    @Before
    public void setUp() {
        movieJsonFinder = new MovieJsonFinder();

    }


    @Test
    public void testFindAll() {

        List<Movie> all = movieJsonFinder.findAll();

        assertThat(all.size(), is(4));

    }

}
