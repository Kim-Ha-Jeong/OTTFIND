package ToyProject.OttFind.service;

import ToyProject.OttFind.domain.Film;
import ToyProject.OttFind.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class FilmService {
    @Autowired
    private final FilmRepository filmRepository;

    public void validateDuplicateFilm(Film film){
        List<Film> result = filmRepository.findByTitle(film.getTitle());

        if(result.size() == 0) return;

        for(Film tmp : result){
            if((film.getDirector().equals(tmp.getDirector()))){
                throw new IllegalStateException("이미 존재하는 영화/드라마입니다");
            }
        }
    }

    public FilmService(FilmRepository filmRepository){
        this.filmRepository = filmRepository;
    }

    public Integer saveFilm(Film film){
        System.out.println(film.getTitle()+" "+film.getDirector());
        validateDuplicateFilm(film);
        filmRepository.save(film);
        return film.getId();
    }

    public List<Film> getAllFilms(){
        return filmRepository.findAll();
    }

    public List<Film> findFilmByTitle(String title){
        return filmRepository.findByTitle(title);
    }
}
