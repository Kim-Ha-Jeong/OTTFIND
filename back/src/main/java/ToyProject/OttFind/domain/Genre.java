package ToyProject.OttFind.domain;

import javax.persistence.*;
import java.util.List;

@Entity(name="genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@OneToMany(mappedBy = "film", cascade = {CascadeType.REFRESH, CascadeType.REMOVE})
    private Integer id;

    @Column(nullable = false)
    private String name;

    public void setName(String name) {
        this.name = name;
    }
}
