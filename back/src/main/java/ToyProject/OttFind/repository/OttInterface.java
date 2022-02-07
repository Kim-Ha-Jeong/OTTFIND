package ToyProject.OttFind.repository;

import ToyProject.OttFind.domain.Ott;

import java.util.List;

public interface OttInterface {
    List<Ott> findAll();
    List<Ott> findOttByFilm(Integer id);
}
