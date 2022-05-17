package models;

import Dao.Sql2oPlacesDao;

import org.junit.Rule;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Sql2oPlacesDaoTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void save_insertsObjectIntoDatabase_true() {
        Places places = new Places("kenya","kenya","www.image.com","cool");
        Sql2oPlacesDao sql2oPlacesDao;
        sql2oPlacesDao.addPlace(places);
        assertTrue(sql2oPlacesDao.getAllPlaces().get(0).equals(places));
    }
    @Test
    public void EndangeredAnimal_instantiatesgetDestination_true() {
        Places places = new Places("kenya","kenya","www.image.com","cool");
        Sql2oPlacesDao sql2oPlacesDao = new Sql2oPlacesDao();
        assertEquals("kenya", places.getDestination());
    }
    @Test
    public void all_returnsAllInstancesOfMonster_true() {
        Places places= new Places("kenya","kenya","www.image.com","cool");
        Sql2oPlacesDao sql2oPlacesDao = new Sql2oPlacesDao();
        sql2oPlacesDao.addPlace(places);
        Sql2oPlacesDao sql2oPlacesDao1 = new Sql2oPlacesDao();
        sql2oPlacesDao1.addPlace(places);
        assertEquals(true, sql2oPlacesDao.getAllPlaces().get(0).equals(sql2oPlacesDao));
        assertEquals(true, sql2oPlacesDao.getAllPlaces().get(1).equals(sql2oPlacesDao1));
    }













































}
