package com.eap.plh24;

import java.util.ArrayList;
import java.util.List;

public class Customer implements BookingListener {
	private String customID;
	private String name;
	private int creditCard;
	private List<Property> interestedFor = new ArrayList<>();
	private String preferredRegion;
	private String preferredPropertyType;

	public Customer(String customID, String name, int creditCard) {
		this.customID = customID;
		this.name = name;
		this.creditCard = creditCard;
		this.interestedFor = interestedFor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomID() {
		return customID;
	}

	public void setCustomID(String customID) {
		this.customID = customID;
	}

	public int getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(int creditCard) {
		this.creditCard = creditCard;
	}

	public List<Property> getInterestedFor() {
		return interestedFor;
	}

	public void setInterestedFor(List<Property> interestedFor) {
		this.interestedFor = interestedFor;
	}

	public void addInterested(Property property) {
		interestedFor.add(property);
	}

	public String getPreferredRegion() {
		return preferredRegion;
	}

	public void setPreferredRegion(String preferredRegion) {
		this.preferredRegion = preferredRegion;
	}

	public String getPreferredPropertyType() {
		return preferredPropertyType;
	}

	public void setPreferredPropertyType(String preferredPropertyType) {
		this.preferredPropertyType = preferredPropertyType;
	}

	// This method is called when a customer wants to book a room
	// It returns true if the property details meet the customer requirements. Otherwise, it returns false

	public boolean isInterested(Property property) {
		if (property.isAvailable)
			for (Property interestedProperty : interestedFor) {
				if (property.getLocation().equals(interestedProperty.getLocation())) {
					if (property.getClass().equals(interestedProperty.getClass())) {
						System.out.printf("The custumer %s with id %s is interested for a property at lacation %s%n", name, customID,property.getLocation());
						return true;
					}
				}
			}
		System.out.printf("The custumer %s with id %s is interested for a property at lacation %s%n", name, customID,property.getLocation());
		return false;
	}

	@Override
	public void makeReservation(Property property) {
		System.out.printf("Make a reservation at %s%n", property);
	}

	@Override
	public String toString () {
		return "Customer with id: '%s', '%s', %d}".formatted(customID, name, creditCard);
	}
}
