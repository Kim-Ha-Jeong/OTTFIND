package ToyProject.OttFind.repository;

import ToyProject.OttFind.domain.Film;

import java.util.List;
import java.util.Optional;

public interface FilmInterface extends JpaRepository<Film> {
    List<Film> findByTitle(String title);
    List<Film> findByYear(Integer year);
    List<Film> findByGenre(String genreName);
    List<Film> findByCountry(String country);
    List<Film> findByType(String type);
    List<Film> findByOtt(String ott);
}
