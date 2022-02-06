package ToyProject.OttFind.service;

import ToyProject.OttFind.domain.Film;
import ToyProject.OttFind.domain.Genre;
import ToyProject.OttFind.repository.FilmInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class FilmServiceTest {

    @Autowired
    FilmService filmService;

    @Autowired
    FilmInterface filmRepository;

    public void setUp() throws Exception{
        Genre genre = Genre.builder().name("액션").id(1).build();

        Film film = Film.builder().title("바보").poster_url("정보없음").season(-1).time(109).country("미국").type("영화").director("spring").genre(genre).year(2021).build();
        filmService.saveFilm(film);
    }

    @Test
    void 저장_잘되는지_확인() throws Exception {
        setUp();
        List<Film> film = filmService.findFilmByTitle("바보");
        assertThat(film.size()).isGreaterThan(0);
    }

    @Test
    void 이름으로_조회(){
        List<Film> result = filmService.findFilmByTitle("모가디슈");
        assertThat(result.size()).isGreaterThan(0);
        assertThat(result.get(0).getTitle()).isEqualTo("모가디슈");
    }

}