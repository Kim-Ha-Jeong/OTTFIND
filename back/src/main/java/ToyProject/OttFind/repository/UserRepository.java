package ToyProject.OttFind.repository;

import ToyProject.OttFind.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends GeneralRepository<User>{
    Optional<User> findByUserName(String username);
}
