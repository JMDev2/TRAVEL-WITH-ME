package Dao;

import models.Places;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Sql2oPlacesDaoTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void save_insertsObjectIntoDatabase_true() {
        Places places = new Places("kenya","kenya","www.image.com","cool");
        Sql2oPlacesDao sql2oPlacesDao = new Sql2oPlacesDao();
        sql2oPlacesDao.addPlace(places);
        assertTrue(sql2oPlacesDao.getAllPlaces().get(0).equals(places));
    }
    @Test
    public void EndangeredAnimal_instantiatesgetDestination_true() {
        Places places = new Places("kenya","kenya","www.image.com","cool");
        Sql2oPlacesDao sql2oPlacesDao = new Sql2oPlacesDao();
        assertEquals("kenya", places.getDestination());
    }



}
