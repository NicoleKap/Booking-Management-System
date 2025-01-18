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

    @Override
    public String toString() {
        return "Property{" +
                "cost=" + cost +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
