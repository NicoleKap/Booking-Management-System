package com.eap.plh24;

public abstract class Property {
    String name;
    String location;
    int cost;
    boolean isAvailable;

    public Property(String name, String location, int cost) {
        this.name = name;
        this.location = location;
        this.cost = cost;
        this.isAvailable = true;
    }

    public Property(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Property{cost=%d, name='%s', location='%s'}".formatted(cost, name, location);
    }
}
