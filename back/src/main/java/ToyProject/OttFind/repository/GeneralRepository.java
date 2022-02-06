package ToyProject.OttFind.repository;

import java.util.List;
import java.util.Optional;

public interface GeneralRepository<T>{
    T save(T data);
    Optional<T> findById(Integer id);
    List<T> findAll();
}
