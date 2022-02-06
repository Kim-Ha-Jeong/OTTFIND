package ToyProject.OttFind.repository;

import ToyProject.OttFind.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInterface extends JpaRepository<User> {
    Optional<User> findByUserName(String username);
}
