package ToyProject.OttFind.service;

import ToyProject.OttFind.domain.User;
import ToyProject.OttFind.repository.UserInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    UserInterface userRepository;

    @Test
    void 회원가입() throws Exception{
        User user = User.builder().username("김하정").password("12345").build();

        Integer id = userService.join(user);

        User findUser = userRepository.findById(id).get();
        assertEquals(user.getUsername(), findUser.getUsername());
    }


    @Test
    void 중복가입() throws Exception{
        User user1 = User.builder().username("spring").password("1234").build();
        User user2 = User.builder().username("spring").password("1234").build();

        userService.join(user1);
        IllegalStateException e = assertThrows(IllegalStateException.class, ()-> userService.join(user2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 user입니다");
    }

}