import Dao.Sql2oPlacesDao;
import Dao.Sql2oReviewsDao;
import models.DB;
import models.Places;
import models.Reviews;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

//        Reviews reviews = new Reviews("maina", 1, "cool",2);
//        Sql2oReviewsDao sql2oReviewsDao = new Sql2oReviewsDao(DB.sql2o);
//        sql2oReviewsDao.addReview(reviews);
//        System.out.println(sql2oReviewsDao.getAllReviews());

//        index page

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

//            place form
        get("/destination-form/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
//            String heroName = request.queryParams("name");
            return new ModelAndView(model, "destination-form.hbs");
        }, new HandlebarsTemplateEngine());


//        Posting the places
        post("/destinationdetails/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String destinantion = request.queryParams("destinantion");
            String location = request.queryParams("location");
            String imageurl = request.queryParams("imageurl");
            String description = request.queryParams("description");
            Places places = new Places(destinantion, location, imageurl, description);
            Sql2oPlacesDao sql2oPlacesDao = new Sql2oPlacesDao(DB.sql2o);
            sql2oPlacesDao.addPlace(places);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

//        display all places
        get("/index", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Sql2oPlacesDao sql2oPlacesDao = new Sql2oPlacesDao(DB.sql2o);
            model.put("places", sql2oPlacesDao.getAllPlaces());
            return new ModelAndView(model, "index.hbs");

        }, new HandlebarsTemplateEngine());



//        reviews
         get("/review-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
//            String heroName = request.queryParams("name");
            return new ModelAndView(model, "review-form.hbs");
        }, new HandlebarsTemplateEngine());


//        Post a reviews
        post("/reviewsdetails/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int rating = Integer.parseInt(request.queryParams("rating"));
            String message = request.queryParams("message");
            int placeid = Integer.parseInt(request.queryParams("placeid"));
            System.out.println(placeid);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//            String  timeAtm = formatter.format(new Timestamp(new Date().getTime()));
            Reviews reviews = new Reviews(name, rating, message, placeid);
            Sql2oReviewsDao sql2oReviewsDao = new Sql2oReviewsDao(DB.sql2o);
            sql2oReviewsDao.addReview(reviews);
            List<Reviews> getAllReviews = sql2oReviewsDao.getAllReviews();
            model.put("review", getAllReviews);
            return new ModelAndView(model, "reviewsdetails.hbs");
//            response.redirect("/");

        }, new HandlebarsTemplateEngine());

//        Display all reviews

        get("/reviewsdetails", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Sql2oPlacesDao sql2oPlacesDao = new Sql2oPlacesDao(DB.sql2o);
            model.put("review", sql2oPlacesDao.getAllPlaces());
            return new ModelAndView(model, "reviewsdetails.hbs");

        }, new HandlebarsTemplateEngine());


    }


}
