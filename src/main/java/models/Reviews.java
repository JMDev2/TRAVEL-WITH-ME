package models;

import java.sql.Timestamp;
import java.util.Objects;

public class Reviews {
    private int id;
    private String name;
    private int rating;
    private String message;
    private int placeid;
    private Timestamp createdAt;

    public Reviews(String name, int rating, String message, int placeid) {
        this.name = name;
        this.rating = rating;
        this.message = message;
        this.placeid = placeid;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPlaceid() {
        return placeid;
    }

    public void setPlaceid(int placeid) {
        this.placeid = placeid;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reviews reviews = (Reviews) o;
        return id == reviews.id &&
                rating == reviews.rating &&
                placeid == reviews.placeid &&
                Objects.equals(name, reviews.name) &&
                Objects.equals(message, reviews.message) &&
                Objects.equals(createdAt, reviews.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rating, message, placeid, createdAt);
    }
}
