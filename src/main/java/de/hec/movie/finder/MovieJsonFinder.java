package de.hec.movie.finder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.hec.movie.model.Movie;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

@Repository
@Profile("json")
public class MovieJsonFinder implements MovieFinder {

    @Override
    public List<Movie> findAll() {

            Movie[] movies;
        try(Reader reader = new InputStreamReader(MovieJsonFinder.class.getResourceAsStream("movies.json"), "UTF-8")){

            Gson gson = new GsonBuilder().create();
            movies = gson.fromJson(reader, Movie[].class);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return Arrays.asList(movies);
    }
}
