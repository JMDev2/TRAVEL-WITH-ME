package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlacesTest {

    @Test
    public void getName_instantiatesWithDestination_String() {
        Places places = new Places("kenya", "kenya", "www.images.com", "nice place");
        assertEquals("kenya", places.getDestination());
    }
    @Test
    public void getName_instantiatesWithLocation_String() {
        Places places = new Places("kenya", "kenya", "www.images.com", "nice place");
        assertEquals("kenya", places.getLocation());
    }

    @Test
    public void getName_instantiatesWithImageUrl_String() {
        Places places = new Places("kenya", "kenya", "www.images.com", "nice place");
        assertEquals("www.images.com", places.getImageUrl());
    }
}



