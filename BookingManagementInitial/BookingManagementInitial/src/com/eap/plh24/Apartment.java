package com.eap.plh24;

public class Apartment extends Property{
    private int squareMeters;
    private boolean garden;

    public Apartment(String name, String location, int cost, int squareMeters, boolean garden) {
        super(name, location, cost);

    }
    public Apartment(String location){
        super(location);

    }

    public int getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(int squareMeters) {
        this.squareMeters = squareMeters;
    }

    public boolean isGarden() {
        return garden;
    }

    public void setGarden(boolean garden) {
        this.garden = garden;
    }
}
