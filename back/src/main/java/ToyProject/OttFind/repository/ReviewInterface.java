package ToyProject.OttFind.repository;

import ToyProject.OttFind.domain.Film;
import ToyProject.OttFind.domain.Review;
import ToyProject.OttFind.domain.User;

import java.util.List;

public interface ReviewInterface extends JpaRepository<Review>{
    List<Review> findByUser(Integer id);
    List<Review> findByFilm(Integer id);
}
