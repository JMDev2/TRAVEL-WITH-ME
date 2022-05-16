package models;

public class Places {
    private int id;
    private String destination;
    private String location;
    private String imageUrl;
    private String description;

    public Places(int id, String destination, String location, String imageUrl, String description) {
        this.id = id;
        this.destination = destination;
        this.location = location;
        this.imageUrl = imageUrl;
        this.description = description;
    }
}
