package ToyProject.OttFind.service;

import ToyProject.OttFind.domain.Review;
import ToyProject.OttFind.repository.ReviewInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class ReviewService {
    @Autowired
    private final ReviewInterface reviewRepository;

    public ReviewService(ReviewInterface reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Integer saveReview(Review review){
        reviewRepository.save(review);
        return review.getId();
    }

    public List<Review> getReviewByUser(Integer id){
        return reviewRepository.findByUser(id);
    }

    public List<Review> getReviewByFilm(Integer id){
        return reviewRepository.findByFilm(id);
    }

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Integer id){
        return reviewRepository.findById(id);
    }
}
