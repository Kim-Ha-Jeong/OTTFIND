package ToyProject.OttFind.config;

import ToyProject.OttFind.repository.FilmRepository;
import ToyProject.OttFind.repository.JpaFilmRepository;
import ToyProject.OttFind.repository.JpaUserRepository;
import ToyProject.OttFind.repository.UserRepository;
import ToyProject.OttFind.service.FilmService;
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
    public UserRepository userRepository(){
        return new JpaUserRepository(em);
    }

    @Bean
    public FilmService filmService(){
        return new FilmService(filmRepository());
    }

    @Bean
    public FilmRepository filmRepository(){
        return new JpaFilmRepository(em);
    }
}
