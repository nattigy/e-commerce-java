package sample.models;

public class Item {
    private String id;
    private String name;
    private String price;
    private String description;
    private String ownerId;
    private String imgSrc;
    private String color;

    public Item(String id, String name, String price, String description, String ownerId, String imgSrc, String color) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.ownerId = ownerId;
        this.imgSrc = imgSrc;
        this.color = color;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
