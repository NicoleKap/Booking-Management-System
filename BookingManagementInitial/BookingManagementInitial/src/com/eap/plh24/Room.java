package com.eap.plh24;

//Η συγκεκριμένη κλάση υπάρχει αλλά δε χρησιμοποιείται ιδιαίτερα στην γραπτή εργασία 2.
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
