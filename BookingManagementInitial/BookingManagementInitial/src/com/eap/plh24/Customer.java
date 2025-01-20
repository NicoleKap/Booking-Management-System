package com.eap.plh24;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String custID;
	private String name;
	private int creditCard;
	private List<Property> interestedFor;


	public Customer(String custID, String name, int creditCard, List<Property> interestedFor) {
		this.custID = custID;
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

	public String getCustID() {
		return custID;
	}

	public void setCustID(String custID) {
		this.custID = custID;
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

	//Για την υλοποίηση της μεθόδου isInterested (Ερώτημα 2.Β) σημειώνονται τα ακόλουθα (ενδεικτικά για την υποβοήθηση του φοιτητή):
	//Θα πρέπει να ελέγχουμε αν το εκάστοτε κατάλυμα, είναι στη λίστα αυτών που ενδιαφέρουν τον πελάτη. Για αυτό:
	//Θα πρέπει να ελέγχουμε αν εξακουθεί να είναι διαθέσιμο (αφού όλοι οι πελάτες ενημερώνονται..)
	//Θα πρέπει να ελέγχουμε την τοποθεσία
	//Θα πρέπει να ελέγουχμε τον τύπο του καταλύματος.
	//Εφόσον υπάρξει ενδιαφέρον, καλό θα ήταν να αφαιρείται από τη λίστα του πελάτη (δεχόμαστε ότι το σύστημα θα το "δεσμεύσει" για εμάς)


}
