import Dao.PlacesDao;
import Dao.ReviewsDao;
import Dao.Sql2oPlacesDao;
import Dao.Sql2oReviewsDao;
import models.DB;
import models.Places;
import models.Reviews;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

//        PlacesDao placesDao = new PlacesDao();
//        ReviewsDao reviewsDao = new ReviewsDao()
        String connectionString = "jdbc:postgresql://localhost:5432/travelwithme";
        Sql2o sql2o = new Sql2o(connectionString, "postgres", "MAINA");




        Sql2oPlacesDao placesDao = new Sql2oPlacesDao(sql2o);
        Sql2oReviewsDao reviewsDao = new Sql2oReviewsDao(sql2o);


//        Reviews reviews = new Reviews("maina", 1, "cool",2);
//        Sql2oReviewsDao sql2oReviewsDao = new Sql2oReviewsDao(DB.sql2o);
//        sql2oReviewsDao.addReview(reviews);
//        System.out.println(sql2oReviewsDao.getAllReviews());

//        Places places = new Places("uganda", "kampala", "www.imgaes.com", "cool");
//        Sql2oPlacesDao sql2oPlacesDao = new Sql2oPlacesDao(DB.sql2o);
//        sql2oPlacesDao.addPlace(places);
//        System.out.println("INSERTED");
//    }
//}


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
//            Sql2oPlacesDao sql2oPlacesDao = new Sql2oPlacesDao(DB.sql2o);
            placesDao.addPlace(places);
            List<Places> getAllPlaces = placesDao.getAllPlaces();
            model.put("places", getAllPlaces);
            return new ModelAndView(model, "index.hbs");

//            response.redirect("/");
        }, new HandlebarsTemplateEngine());

//        display all places
        get("/index", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
//            Sql2oPlacesDao sql2oPlacesDao = new Sql2oPlacesDao(DB.sql2o);
            model.put("places", placesDao.getAllPlaces());
            return new ModelAndView(model, "index.hbs");

        }, new HandlebarsTemplateEngine());


//        reviews form
        get("/review-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "review-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/review-form/:id",(request, response)->{
            Map<String, Object>model = new HashMap<>();
//            Sql2oPlacesDao sql2oPlacesDao = new Sql2oPlacesDao(DB.sql2o);
            int id = Integer.parseInt(request.params("id"));
            model.put("id",id);
//            model.put("destinations", placesDao.getAllPlaces());
            return new ModelAndView(model, "review-form.hbs");
        }, new HandlebarsTemplateEngine());


//        Post a reviews
        post("/reviewsdetails/new/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int rating = Integer.parseInt(request.queryParams("rating"));
            String message = request.queryParams("message");
            int placeid = Integer.parseInt(request.params("id"));
            System.out.println(placeid);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//            String  timeAtm = formatter.format(DateFormat.getDateInstance());
            Reviews reviews = new Reviews(name, rating, message, placeid);
//            Sql2oReviewsDao sql2oReviewsDao = new Sql2oReviewsDao(DB.sql2o);
            reviewsDao.addReview(reviews);
            List<Reviews> getAllReviews = reviewsDao.getAllReviews();
            model.put("review", getAllReviews);

            response.redirect("/place/"+ placeid);
//            response.redirect("/");

            return null;

        }, new HandlebarsTemplateEngine());

//        Display all reviews on the nav bar

        get("/reviewsdetails", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
//            Sql2oPlacesDao sql2oPlacesDao = new Sql2oPlacesDao(DB.sql2o);
            model.put("review", placesDao.getAllPlaces());
            return new ModelAndView(model, "reviewsdetails.hbs");

        }, new HandlebarsTemplateEngine());

        //get a specifc place details and it's reviews


//

        get("/place/:id",(request, response)->{
            Map<String, Object>model = new HashMap<>();
            int placeid = Integer.parseInt(request.params("id"));

            Places foundPlace = placesDao.getAllPlacesById(placeid);
            model.put("places", foundPlace);

            List<Reviews> myReviews = reviewsDao.getAllIndividualReviewsByReviews(placeid);
            model.put("review", myReviews);
            model.put("place", foundPlace);


            return new ModelAndView(model, "individualreviews.hbs");
        }, new HandlebarsTemplateEngine());

    }
}



