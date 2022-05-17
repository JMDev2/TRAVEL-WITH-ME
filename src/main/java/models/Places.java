package models;

import java.util.Objects;

public class Places {
    private int id;
    private String destinantion;
    private String location;
    private String imageurl;
    private String description;

    public Places(String destinantion, String location, String imageurl, String description) {
        this.destinantion = destinantion;
        this.location = location;
        this.imageurl = imageurl;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestinantion() {
        return destinantion;
    }

    public void setDestinantion(String destinantion) {
        this.destinantion = destinantion;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
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
                Objects.equals(destinantion, places.destinantion) &&
                Objects.equals(location, places.location) &&
                Objects.equals(imageurl, places.imageurl) &&
                Objects.equals(description, places.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, destinantion, location, imageurl, description);
    }
}
