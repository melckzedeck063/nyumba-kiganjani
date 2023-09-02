package com.example.dkiganjani;

public class Property {
    public String owner,property,location,pay_duration, description;
    public  int image;

    public Property(){

    }


    public Property(String owner, String property, String location, String pay_duration, String description, int image) {
        this.owner = owner;
        this.property = property;
        this.location = location;
        this.pay_duration = pay_duration;
        this.description = description;
        this.image = image;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPay_duration() {
        return pay_duration;
    }

    public void setPay_duration(String pay_duration) {
        this.pay_duration = pay_duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
