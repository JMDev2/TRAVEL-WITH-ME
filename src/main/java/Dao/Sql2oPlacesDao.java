package Dao;

import models.Places;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;


import org.sql2o.Connection;
import java.util.List;

public class Sql2oPlacesDao implements PlacesDao {
    private final Sql2o sql2o;
    public Sql2oPlacesDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }
    @Override
    public void addPlace(Places places) {
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO places (destination, location, imageurl, description) VALUES (:destination, :location, :imageurl, :description)";
            int id = (int) conn.createQuery(sql,true)
                    .bind(places)
                    .executeUpdate()
                    .getKey();
            places.setId(id);

        }catch (Sql2oException ex){
            System.out.println(ex);
        }



    }

    @Override
    public List<Places> getAllPlaces() {
        return null;
    }

    @Override
    public Places getAllPlacesById(int id) {
        return null;
    }

    @Override
    public void deletePlaceById(int id) {

    }
}
