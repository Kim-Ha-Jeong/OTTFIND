package ToyProject.OttFind.service;

import ToyProject.OttFind.domain.Film;
import ToyProject.OttFind.domain.Genre;
import ToyProject.OttFind.repository.FilmRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class FilmServiceTest {

    @Autowired
    FilmService filmService;

    @Autowired
    FilmRepository filmRepository;

    @Test
    void 단순저장() {
        Film film = new Film();
        Genre genre = new Genre();
        genre.setName("호러");

        film.setType("영화");
        film.setDirector("spring");
        film.setYear(2021);
        film.setTitle("바보");
        film.setGenre(genre);
        film.setTime(120);
        film.setSeason(-1);
        film.setPoster_url("정보없음");

        System.out.println(film.getTitle()+" "+film.getDirector());

        Integer id = filmService.saveFilm(film);

        Film findFilm = filmRepository.findById(id).get();
        assertEquals(id, findFilm.getId());
    }

    @Test
    void 중복저장() {
        Film film1 = new Film();
        Genre genre = new Genre();
        genre.setName("호러");

        film1.setType("영화");
        film1.setDirector("spring");
        film1.setYear(2021);
        film1.setTitle("바보");
        film1.setGenre(genre);
        film1.setTime(120);

        Film film2 = new Film();

        film2.setType("영화");
        film2.setDirector("spring");
        film2.setYear(2021);
        film2.setTitle("바보");
        film2.setGenre(genre);
        film2.setTime(120);

        filmService.saveFilm(film1);
        IllegalStateException e = assertThrows(IllegalStateException.class, ()-> filmService.saveFilm(film2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 영화/드라마입니다");

    }

    @Test
    void getAllFilms() {
    }

    @Test
    void findFilmByTitle() {
    }
}