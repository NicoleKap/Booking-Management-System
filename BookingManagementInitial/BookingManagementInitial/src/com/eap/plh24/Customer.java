package com.eap.plh24;

import java.util.List;

public class Customer {
	private String customID;
	private String name;
	private int creditCard;
	private List<Property> interestedFor;


	public Customer(String customID, String name, int creditCard, List<Property> interestedFor) {
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

	public List<Property> addInterested(Property property) {
		interestedFor.add(property);
        return interestedFor;
    }

	// This method is called when a customer wants to book a room
	// It returns true if the property details meet the customer requirements. Otherwise, it returns false

	public boolean isInterested(Property property) {
		if (property.isAvailable)
			for(Property interestedProperty : interestedFor) {
				if(property.getLocation().equals(interestedProperty.getLocation())) {
					if(property.getClass().equals(interestedProperty.getClass()))
						return true;
				}
			}
        return false;
    }

}
