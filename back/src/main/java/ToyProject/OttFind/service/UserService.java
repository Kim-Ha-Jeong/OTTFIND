package ToyProject.OttFind.service;

import ToyProject.OttFind.domain.User;
import ToyProject.OttFind.repository.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class UserService {
    @Autowired
    private final UserInterface userRepository;

    public UserService(UserInterface userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public Optional<User> findUser(Integer userId){
        return userRepository.findById(userId);
    }

    public void validateDuplicateUser(User user){
        userRepository.findByUserName(user.getUsername())
                .ifPresent(u -> {
                    throw new IllegalStateException("이미 존재하는 user입니다");
                });
    }

    public Integer join(User user){
        validateDuplicateUser(user);
        userRepository.save(user);
        return user.getId();
    }
}
