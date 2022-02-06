package ToyProject.OttFind.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity(name="film")
@NoArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 300, columnDefinition = "default '정보 없음'")
    private String poster_url;

    @Column(nullable = false, length = 45)
    private String type;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false, columnDefinition = "default -1")
    private Integer time;

    @Column(nullable = false, columnDefinition = "default -1")
    private Integer season;

    @Column(nullable = false, length = 45)
    private String director;

    @Column(nullable = false, length = 45)
    private String country;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;


    @Builder
    private Film(Integer id, String title, String type, String poster_url, Integer time, Integer season, String country, String director, Genre genre, Integer year){
        this.id = id;
        this.time = time;
        this.title = title;
        this.type = type;
        this.poster_url = poster_url;
        this.season = season;
        this.country = country;
        this.director = director;
        this.genre = genre;
        this.year = year;
    }

}
