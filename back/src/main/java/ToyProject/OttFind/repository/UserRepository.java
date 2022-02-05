package ToyProject.OttFind.repository;

import ToyProject.OttFind.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository {
    User save(User user);
    Optional<User> findById(Integer id);
    Optional<User> findByUserName(String username);
    List<User> findAll();
}
