package ToyProject.OttFind.controller;

import ToyProject.OttFind.domain.Review;
import ToyProject.OttFind.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/review")
    public List<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }

    @RequestMapping(value = "/review", params = "user_id")
    public List<Review> getReviewByUser(@RequestParam("user_id") Integer id){
        return reviewService.getReviewByUser(id);
    }

    @RequestMapping(value = "/review", params = "film_id")
    public List<Review> getReviewByFilm(@RequestParam("film_id") Integer id){
        return reviewService.getReviewByFilm(id);
    }
}
