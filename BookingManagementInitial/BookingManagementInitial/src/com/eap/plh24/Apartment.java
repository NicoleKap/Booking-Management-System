package com.eap.plh24;

public class Apartment extends Property{
    private int squareMeters;
    private boolean garden;

    public Apartment(String name, String location, int cost, int squareMeters, boolean garden) {
        super(name, location, cost);
        this.garden = garden;

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

    public void booked(){
        setAvailable(false);
    }

    @Override
    public String toString() {
        return "Apartment{name=%s, location=%s, garden=%s, squareMeters=%d cost= %d}".formatted(getName(),getLocation(), garden, squareMeters, cost);
    }
}
