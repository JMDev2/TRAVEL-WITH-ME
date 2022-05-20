package Dao;

import models.Reviews;

import java.util.List;

public interface ReviewsDao {
//    CRUD
    void addReview(Reviews reviews);

//    Read
    List<Reviews> getAllReviews();
    Reviews findReviewsById(int id);
    List<Reviews> getAllIndividualReviewsByReviews(int reviewId);

//    update

//    Delete
    void deleteReviewById(int id);
}
