package models;

import java.util.Objects;

public class Places {
    private int id;
    private String destination;
    private String location;
    private String imageUrl;
    private String description;

    public Places(String destination, String location, String imageUrl, String description) {
        this.destination = destination;
        this.location = location;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Places places = (Places) o;
        return id == places.id &&
                Objects.equals(destination, places.destination) &&
                Objects.equals(location, places.location) &&
                Objects.equals(imageUrl, places.imageUrl) &&
                Objects.equals(description, places.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, destination, location, imageUrl, description);
    }
}
