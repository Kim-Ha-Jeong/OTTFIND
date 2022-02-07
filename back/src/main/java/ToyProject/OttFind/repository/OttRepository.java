package ToyProject.OttFind.repository;

import ToyProject.OttFind.domain.Film;
import ToyProject.OttFind.domain.Ott;

import javax.persistence.EntityManager;
import java.util.List;

public class OttRepository implements OttInterface {
    private final EntityManager em;

    public OttRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Ott> findAll() {
        return em.createQuery("select o from ott o", Ott.class).getResultList();
    }

    @Override
    public List<Ott> findOttByFilm(Integer id) {
        List<Ott> result = em.createQuery("select o from film_in_ott fo, ott o where o.id=fo.ott and fo.film=:id", Ott.class)
                .setParameter("id", new Film().builder().id(id).build())
                .getResultList();
        return result;
    }
}
