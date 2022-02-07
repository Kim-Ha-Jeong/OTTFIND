package ToyProject.OttFind.config;

import ToyProject.OttFind.repository.*;
import ToyProject.OttFind.service.FilmService;
import ToyProject.OttFind.service.ReviewService;
import ToyProject.OttFind.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    private final EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em){
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public UserService userService(){
        return new UserService(userRepository());
    }

    @Bean
    public UserInterface userRepository(){
        return new UserRepository(em);
    }

    @Bean
    public FilmService filmService(){
        return new FilmService(filmRepository());
    }

    @Bean
    public FilmInterface filmRepository(){
        return new FilmRepository(em);
    }

    @Bean
    public ReviewService reviewService(){
        return new ReviewService(reviewRepository());
    }

    @Bean
    public ReviewInterface reviewRepository(){
        return new ReviewRepository(em);
    }

}
