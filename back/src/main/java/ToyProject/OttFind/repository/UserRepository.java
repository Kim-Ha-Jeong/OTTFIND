package ToyProject.OttFind.repository;

import ToyProject.OttFind.domain.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class UserRepository implements UserInterface {
    private final EntityManager em;

    public UserRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public User save(User user){
        em.persist(user);
        return user;
    }

    @Override
    public Optional<User> findById(Integer id){
        User user = em.find(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> findAll(){
        return em.createQuery("select u from user u", User.class).getResultList();
    }

    @Override
    public Optional<User> findByUserName(String username){
        List<User> result = em.createQuery("select u from user u where u.username=:username", User.class)
                .setParameter("username", username)
                .getResultList();
        return result.stream().findAny();
    }

}
