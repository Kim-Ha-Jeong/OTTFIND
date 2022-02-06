package ToyProject.OttFind.repository;

import ToyProject.OttFind.domain.Film;

import java.util.List;
import java.util.Optional;

public interface FilmInterface extends JpaRepository<Film> {
    List<Film> findByTitle(String title);
    Optional<Film> findByYear(int year);
    List<Film> findByGenre(String genreName);
    Optional<Film> findByCountry(String country);
}
