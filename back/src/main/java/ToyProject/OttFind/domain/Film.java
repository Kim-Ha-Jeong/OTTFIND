package ToyProject.OttFind.domain;

import javax.persistence.*;

@Entity(name="film")
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

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "genre_id")
    private Genre genre;

    public Integer getId() {
        return id;
    }

    public String getDirector() {
        return director;
    }

    public String getTitle() {
        return title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public void setPoster_url(String poster_url) {
        this.poster_url = poster_url;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }
}
