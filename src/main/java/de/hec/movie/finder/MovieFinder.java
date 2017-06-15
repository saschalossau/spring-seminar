package de.hec.movie.finder;

import de.hec.movie.model.Movie;
import org.springframework.beans.factory.BeanNameAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

public interface MovieFinder extends BeanNameAware {

    List<Movie> findAll();

    String[] beanName = new String[1];


    @PostConstruct
    default void postConstruct() {
        System.out.println("Huhu: " + beanName[0]);
    }

    default void setBeanName(String beanName) {
        this.beanName[0] = beanName;
    }


    @PreDestroy
    default void preDestruct() {
        System.out.println("Ciao: " + beanName[0]);
    }

}