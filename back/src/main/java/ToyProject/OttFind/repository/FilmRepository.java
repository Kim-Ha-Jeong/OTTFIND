package ToyProject.OttFind.repository;

import ToyProject.OttFind.domain.Film;
import ToyProject.OttFind.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface FilmRepository extends GeneralRepository<Film>{
    List<Film> findByTitle(String title);
    Optional<Film> findByYear(int year);
    Optional<Film> findByGenre(Genre genre);
    Optional<Film> findByCountry(String country);
}
