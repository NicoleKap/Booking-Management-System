package com.eap.plh24;

public abstract class Property {
    String name;
    String location;
    int cost;
    boolean isAvailable;

    @Override
    public String toString() {
        return "Property{" +
                "cost=" + cost +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
