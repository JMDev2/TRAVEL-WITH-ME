//package models;
//
//import Dao.Sql2oPlacesDao;
//import Dao.Sql2oReviewsDao;
//import org.junit.Rule;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class Sql2oReviewsTest {
//    @Rule
//    public DatabaseRule database = new DatabaseRule();
//
//    @Test
//    public void save_insertsObjectIntoDatabase_true() {
//        Reviews reviews = new Reviews("maina", 1, "cool", 1);
//        Sql2oReviewsDao sql2oReviewsDao = new Sql2oReviewsDao(DB.sql2o);
//        sql2oReviewsDao.addReview(reviews);
//        assertTrue(sql2oReviewsDao.getAllReviews().get(0).equals(reviews));
//    }
//    }
