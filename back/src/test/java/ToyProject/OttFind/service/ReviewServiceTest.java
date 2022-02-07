package ToyProject.OttFind.service;

import ToyProject.OttFind.domain.Film;
import ToyProject.OttFind.domain.Genre;
import ToyProject.OttFind.domain.Review;
import ToyProject.OttFind.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class ReviewServiceTest {
    @Autowired
    ReviewService reviewService;

    @Autowired
    UserService userService;

    @Autowired
    FilmService filmService;

    Film setUpFilm(){
        return Film.builder().id(7).build();
    }

    User setUpUser(){
        return User.builder().id(1).build();
    }

    @Test
    void 리뷰_저장() {
        Film film = setUpFilm();
        User user = setUpUser();
        Review review = Review.builder().film(film).user(user).content("갸악갸악").build();
        Integer id = reviewService.saveReview(review);

        assertThat(reviewService.getReviewById(id)).isNotNull();
    }

    @Test
    void 유저별_리뷰_조회() {
        User user = User.builder().username("kimhajeong").password("aksdljflakds").build();

        Integer userId = userService.join(user);

        Film film = setUpFilm();
        Review review = Review.builder().film(film).user(user).content("노잼").build();
        Integer id = reviewService.saveReview(review);

        assertThat(reviewService.getReviewByUser(userId).get(0).getId()).isEqualTo(id);
    }

    @Test
    void 영화_드라마별_리뷰_조회() {
        Genre genre = Genre.builder().id(1).build();
        Film film = Film.builder().title("내가 만든 영화").year(2022).time(109).type("영화").genre(genre).country("한국").director("김하정").poster_url("정보 없음").season(-1).build();

        Integer filmId = filmService.saveFilm(film);

        Review review = Review.builder().film(film).user(setUpUser()).content("굿").build();
        Integer id = reviewService.saveReview(review);

        assertThat(reviewService.getReviewByFilm(filmId).get(0).getId()).isEqualTo(id);
    }
}