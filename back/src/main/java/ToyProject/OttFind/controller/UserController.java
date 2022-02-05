package ToyProject.OttFind.controller;

import ToyProject.OttFind.domain.User;

import ToyProject.OttFind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> findAllUser(){
        return userService.getAllUser();
    }

    @PostMapping("/user")
    public User signUp(@RequestParam String username, @RequestParam String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.join(user);
        return user;
    }
}
