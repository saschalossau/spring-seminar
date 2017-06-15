package de.hec.movie;

import de.hec.movie.finder.MovieFinder;
import de.hec.movie.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieLister {

    @Autowired
    private MovieFinder finder;

    public String getAllMoviesByCategory(String name) {
        StringBuilder categoryMovies = new StringBuilder();
        List<Movie> allMovies = finder.findAll();
        for (Movie movie : allMovies) {
            if (movie.getCategory().equals(name)) {
                if (categoryMovies.length() > 0) {
                    categoryMovies.append(",");
                }
                categoryMovies.append(movie.getName());
            }
        }

        return categoryMovies.toString();
    }

    public MovieFinder getFinder() {
        return finder;
    }
}
