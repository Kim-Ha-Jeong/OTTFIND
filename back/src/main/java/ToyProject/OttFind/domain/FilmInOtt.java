package ToyProject.OttFind.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name="film_in_ott")
@NoArgsConstructor
public class FilmInOtt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "film_id", referencedColumnName = "id")
    private Film film;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "ott_id", referencedColumnName = "id")
    private Ott ott;

    @Builder
    private FilmInOtt(Integer id, Film film, Ott ott){
        this.id = id;
        this.film = film;
        this.ott = ott;
    }

}
