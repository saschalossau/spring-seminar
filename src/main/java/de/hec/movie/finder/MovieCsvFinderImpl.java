package de.hec.movie.finder;

import de.hec.movie.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import sun.awt.AppContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository("movieCsvFinder")
@Profile("csv")
public class MovieCsvFinderImpl implements MovieFinder {

    @Autowired
    private ApplicationContext appContext;

    @Override
    public List<Movie> findAll() {
        List<Movie> movies = new ArrayList<>();

        Scanner scanner = null;
        try {
            scanner = new Scanner(MovieCsvFinderImpl.class.getResourceAsStream("movies.txt"));
            scanner.useDelimiter(",");

            while (scanner.hasNext()) {
                String name = scanner.next();
                String category = scanner.next();

                Movie movie = getMovie(name, category);
                movies.add(movie);
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return movies;
    }

    private Movie getMovie(String name, String category) {
        return appContext.getBean(Movie.class, name, category);
    }

}
