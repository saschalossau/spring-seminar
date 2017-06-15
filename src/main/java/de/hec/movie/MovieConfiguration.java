package de.hec.movie;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "de.hec.movie")
@PropertySource("classpath:/de/hec/movie/application.properties")
public class MovieConfiguration {

}
