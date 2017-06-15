package de.hec.movie.finder;

import java.util.List;

import com.thoughtworks.xstream.XStream;
import de.hec.movie.model.Movie;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Repository
@Profile("xml")
public class MovieXmlFinderImpl implements MovieFinder {

    @SuppressWarnings("unchecked")
    public List<Movie> findAll() {
        XStream xstream = new XStream();
        List<Movie> movies = (List<Movie>) xstream.fromXML(MovieXmlFinderImpl.class.getResourceAsStream("movies.xml"));

        return movies;
    }

}
