package de.hec.movie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MovieStarter {

    @Value("${category}")
    private String category;

    @Autowired
    private MovieLister movieLister;

    public String findMovies() {
        return movieLister.getAllMoviesByCategory(category);
    }

}
