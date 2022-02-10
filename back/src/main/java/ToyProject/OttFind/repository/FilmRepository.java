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

    public List<Film> findFilm(String data, String col){
        List<Film> result = em.createQuery("select f from film f where f."+col+"=:data", Film.class)
                .setParameter("data", data)
                .getResultList();
        return result;
    }

    @Override
    public List<Film> findByTitle(String title) {
        List<Film> result = em.createQuery("select f from film f where f.title=:title", Film.class)
                .setParameter("title", title)
                .getResultList();

        return result;
    }

    @Override
    public List<Film> findByYear(Integer year) {
        List<Film> result = em.createQuery("select f from film f where f.year=:year", Film.class)
                .setParameter("year", year)
                .getResultList();
        return result;
    }

    @Override
    public List<Film> findByGenre(String genreName) {
        List<Film> result = em.createQuery("select f from film f, genre g where g.id = f.genre and g.name=:name", Film.class)
                .setParameter("name", genreName)
                .getResultList();

        return result;
    }

    @Override
    public List<Film> findByCountry(String country) {
        return findFilm(country, "country");
    }

    @Override
    public List<Film> findByType(String type) {
        return findFilm(type, "type");
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

    @Override
    public List<Film> findByOtt(String ott) {
        List<Film> result = em.createQuery("select f from film f, film_in_ott fo, ott o where f.id = fo.film and fo.ott=o.id and o.name=:name", Film.class)
                .setParameter("name", ott)
                .getResultList();
        return result;
    }
}
