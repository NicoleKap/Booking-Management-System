package com.eap.plh24;

//Η συγκεκριμένη κλάση υπάρχει αλλά δεν χρησιμοποιείται ιδιαίτερα στην γραπτή εργασία 2.
public class Room {
	private int id;
	private String type;

	public Room() {
		id = 0;
		type = "";
	}
	
	public Room(int i, String t) {
		id = i;
		type = t;
	}

	public boolean hasID(int roomID) {
		return (id==roomID);
	}

}
