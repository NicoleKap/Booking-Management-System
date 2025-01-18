package com.eap.plh24;

import java.util.ArrayList;
import java.util.List;

public class Hotel extends Property{
	private List<Room> rooms = new ArrayList<>(); // The hotel room list
	private int availableRooms;
	private boolean breakfast;

	public Hotel(String name, String location, int cost, int numberOfRooms, boolean breakfast) {
        super(name, location, cost);
		this.name = name;
		this.location = location;
		this.cost = cost;
    }

	public Hotel(String location) {
        super(location);
		this.location = location;
    }

}
