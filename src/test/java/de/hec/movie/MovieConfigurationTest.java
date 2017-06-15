package de.hec.movie;

import static org.junit.Assert.*;

import de.hec.movie.finder.MovieCsvFinderImpl;
import de.hec.movie.finder.MovieFinder;
import de.hec.movie.finder.MovieJsonFinder;
import de.hec.movie.finder.MovieXmlFinderImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MovieConfigurationTest {

    AnnotationConfigApplicationContext appContext;

    @Before
    public void movieConfiguration() {
        appContext = new AnnotationConfigApplicationContext(MovieConfiguration.class);
    }

    @Test
    public void testLoadContext() {
        MovieLister bean = appContext.getBean(MovieLister.class);

        assertNotNull(bean);
        assertTrue(bean instanceof MovieLister);

        assertTrue(bean.getFinder() instanceof MovieCsvFinderImpl);

        System.out.println(bean.getAllMoviesByCategory("horror"));
    }

    @After
    public void tearDown() {
        appContext.close();

    }

}
