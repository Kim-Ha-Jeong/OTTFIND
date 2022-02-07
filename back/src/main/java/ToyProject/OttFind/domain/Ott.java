package ToyProject.OttFind.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity(name = "ott")
@NoArgsConstructor
public class Ott {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = false, length = 45)
    private String opt;

    @Builder
    private Ott(Integer id, String name, String opt){
        this.id = id;
        this.name = name;
        this.opt = opt;
    }
}
