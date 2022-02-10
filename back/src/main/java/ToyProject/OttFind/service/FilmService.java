package ToyProject.OttFind.service;

import ToyProject.OttFind.domain.Film;
import ToyProject.OttFind.repository.FilmInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class FilmService {
    @Autowired
    private final FilmInterface filmRepository;

    public void validateDuplicateFilm(Film film){
        List<Film> result = filmRepository.findByTitle(film.getTitle());

        if(result.size() == 0) return;

        for(Film tmp : result){
            if((film.getDirector().equals(tmp.getDirector()))){
                throw new IllegalStateException("이미 존재하는 영화/드라마입니다");
            }
        }
    }

    public FilmService(FilmInterface filmRepository){
        this.filmRepository = filmRepository;
    }

    public Integer saveFilm(Film film){
        validateDuplicateFilm(film);
        filmRepository.save(film);
        return film.getId();
    }

    public List<Film> getAllFilms(){
        return filmRepository.findAll();
    }

    public Optional<Film> findFilmById(Integer id) { return filmRepository.findById(id);}

    public List<Film> findFilmByTitle(String title){
        return filmRepository.findByTitle(title);
    }

    public List<Film> findFilmByGenre(String genreName){
        return filmRepository.findByGenre(genreName);
    }

    public List<Film> findFilmByType(String type){
        return filmRepository.findByType(type);
    }

    public List<Film> findFilmByYear(Integer year){
        return filmRepository.findByYear(year);
    }

    public List<Film> findFilmByCountry(String country){
        return filmRepository.findByCountry(country);
    }

    public List<Film> findFilmByOtt(String ott) { return filmRepository.findByOtt(ott);}
}
