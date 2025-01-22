package com.eap.plh24;

import java.util.ArrayList;
import java.util.List;

public class Hotel extends Property{
	private List<Room> rooms = new ArrayList<>(); // The hotel room list
	private int numberOfRooms;
	private int availableRooms;
	private boolean breakfast;
	int usedRooms = 0;

	public Hotel(String name, String location, int cost, int numberOfRooms, int availableRooms, boolean breakfast) {
        super(name, location, cost);
		this.name = name;
		this.location = location;
		this.cost = cost;
		this.breakfast = breakfast;
		this.numberOfRooms = numberOfRooms;
		usedRooms = numberOfRooms - availableRooms;
    }

	public Hotel(String location) {
        super(location);
		this.location = location;
    }

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public int getAvailableRooms() {
		return availableRooms;
	}

	public void setAvailableRooms(int availableRooms) {
		this.availableRooms = availableRooms;
	}

	public boolean isBreakfast() {
		return breakfast;
	}

	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}

	public void booked() {
		if(availableRooms == 0)
			setAvailable(false);
	}

	@Override
	public String toString() {
		return "Hotel{name=%s, location= %s, breakfast=%s, usedRooms=%d, cost= %d}".formatted(super.name, super.location, breakfast, usedRooms,super.cost);
	}
}
