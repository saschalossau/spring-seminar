package de.hec.movie;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MovieListerTest {
	ClassPathXmlApplicationContext appContext;

	@Before
	public void loadAppContext() {
		appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@After
	public void closeAppContext() {
		appContext.close();
	}

	@Test
	public void testGetAllMoviesByCategory() throws Exception {
		MovieLister lister = appContext.getBean(MovieLister.class);

		String expected = "Ich weiss was Du letzten Sommer getan hast,Scream - Schrei!";
		String result = lister.getAllMoviesByCategory("Horror");

		assertThat(result, is(equalTo(expected)));
	}

}
