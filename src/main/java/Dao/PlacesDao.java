package Dao;

import models.Places;

import java.util.List;

public interface PlacesDao {
//    CRUD
//    Add place
    void addPlace(Places places);

//    READ
    List<Places> getAllPlaces();
    Places getAllPlacesById(int id);
//    List<Reviews> getReviewsByPlace(int placeId);

//    DELETE
    void deletePlaceById(int id);




}
