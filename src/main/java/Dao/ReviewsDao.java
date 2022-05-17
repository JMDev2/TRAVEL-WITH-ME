package Dao;

import models.Reviews;

import java.util.List;

public interface ReviewsDao {
//    CRUD
    void addReview(Reviews reviews);

//    Read
    List<Reviews> getAllReviews();
    Reviews getReviewsById(int id);

//    update

//    Delete
    void deleteReviewById(int id);
}
