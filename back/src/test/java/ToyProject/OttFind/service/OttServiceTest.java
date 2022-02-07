package ToyProject.OttFind.service;

import ToyProject.OttFind.domain.Ott;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class OttServiceTest {

    @Autowired
    OttService ottService;

    @Autowired
    FilmService filmService;

    @Test
    void 해당_영화가_있는_ott_조회() {
        Integer filmId = filmService.findFilmByTitle("모가디슈").get(0).getId();
        List<Ott> result = ottService.getFilmInOtt(filmId);
        assertThat(result.size()).isGreaterThan(0);
    }

    @Test
    void 모든_ott_가져오기() throws Exception {
        List<Ott> allOtt = ottService.getAllOtt();
        assertThat(allOtt.size()).isEqualTo(7);
    }
}