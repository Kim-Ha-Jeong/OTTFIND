package ToyProject.OttFind.repository;

import ToyProject.OttFind.domain.Film;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class FilmRepository implements FilmInterface {
    private final EntityManager em;

    public FilmRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Film> findByTitle(String title) {
        List<Film> result = em.createQuery("select f from film f where f.title=:title", Film.class)
                .setParameter("title", title)
                .getResultList();

        return result;
    }

    @Override
    public Optional<Film> findByYear(int year) {
        return Optional.empty();
    }

    @Override
    public List<Film> findByGenre(String genreName) {
        List<Film> result = em.createQuery("select f from film f, genre g where g.id = f.genre and g.name=:name", Film.class)
                .setParameter("name", genreName)
                .getResultList();

        return result;
    }

    @Override
    public Optional<Film> findByCountry(String country) {
        return Optional.empty();
    }

    @Override
    public Film save(Film film) {
        em.persist(film);
        return film;
    }

    @Override
    public Optional<Film> findById(Integer id) {
        Film film = em.find(Film.class, id);
        return Optional.ofNullable(film);
    }

    @Override
    public List<Film> findAll() {
        return em.createQuery("select f from film f", Film.class).getResultList();
    }
}
