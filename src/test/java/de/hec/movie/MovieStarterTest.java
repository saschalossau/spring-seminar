package de.hec.movie;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MovieStarterTest {

    private ApplicationContext applicationContext;

        private MovieStarter movieStarter;

    @Before
    public void loadAppContext() {
        System.setProperty("spring.profiles.active", "xml");
        applicationContext = new AnnotationConfigApplicationContext(MovieConfiguration.class);

        movieStarter = applicationContext.getBean(MovieStarter.class);
    }


    @Test
    public void testFindMovies() {

        System.out.println(movieStarter.findMovies());
    }

}
