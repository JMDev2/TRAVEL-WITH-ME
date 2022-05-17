package Dao;

import models.Reviews;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oReviewsDao implements ReviewsDao {

    private final Sql2o sql2o;
    public Sql2oReviewsDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }
    @Override
    public void addReview(Reviews reviews) {
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO reviews (name, rating, message,placeid, createAt) VALUIES (:name, :rating, :message, :placeid, :now())";
            int id = (int) conn.createQuery(sql, true)
                    .bind(reviews)
                    .executeUpdate()
                    .getKey();
            reviews.setId(id);
        }catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public List<Reviews> getAllReviews() {
        try(Connection conn = sql2o.open()){
            String sql = "SELECT * FROM reviews";
            return conn.createQuery(sql)
                    .executeAndFetch(Reviews.class);
        }
    }

    @Override
    public Reviews getReviewsById(int id) {
        try(Connection conn = sql2o.open()){
            String sql = "SELECT * FROM reviews WHERE id = :id";
            return  conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Reviews.class);

        }
    }

    @Override
    public void deleteReviewById(int id) {
        try(Connection conn = sql2o.open()){
            String sql = "DELETE FROM reviews WHERE id = :id";
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }

    }
}
