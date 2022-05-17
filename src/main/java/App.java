import Dao.Sql2oPlacesDao;
import models.DB;
import models.Places;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


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
    }





}
