package ToyProject.OttFind.repository;

import ToyProject.OttFind.domain.Review;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class ReviewRepository implements ReviewInterface{
    private final EntityManager em;

    public ReviewRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Review save(Review review) {
        em.persist(review);
        return review;
    }

    @Override
    public Optional<Review> findById(Integer id) {
        Review review = em.find(Review.class, id);
        return Optional.ofNullable(review);
    }

    @Override
    public List<Review> findAll() {
        return em.createQuery("select r from review r", Review.class).getResultList();
    }

    @Override
    public List<Review> findByUser(Integer id) {
        List<Review> result = em.createQuery("select r from review r,user u where r.user=u.id and u.id=:id", Review.class)
                .setParameter("id", id)
                .getResultList();
        return result;
    }

    @Override
    public List<Review> findByFilm(Integer id) {
        List<Review> result = em.createQuery("select r from review r,film f where r.film=f.id and f.id=:id", Review.class)
                .setParameter("id", id)
                .getResultList();
        return result;
    }
}
