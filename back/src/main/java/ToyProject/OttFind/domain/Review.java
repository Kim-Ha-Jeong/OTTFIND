package ToyProject.OttFind.domain;

import ToyProject.OttFind.config.FilmShort;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name="review")
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String content;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "film_id", referencedColumnName = "id")
    private Film film;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Integer getId() {
        return id;
    }

    public FilmShort getFilm(){
        FilmShort filmShort = new FilmShort(film.getTitle(), film.getPoster_url());
        return filmShort;
    }

    public String getUser() {
        return user.getUsername();
    }

    public String getContent() {
        return content;
    }

    @Builder
    private Review(Integer id, String content, Film film, User user){
        this.id = id;
        this.content = content;
        this.film = film;
        this.user = user;
    }
}
