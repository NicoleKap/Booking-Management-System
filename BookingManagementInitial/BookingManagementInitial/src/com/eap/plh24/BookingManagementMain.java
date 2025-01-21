package com.eap.plh24;

import java.util.List;

public class BookingManagementMain {
    static List<Property> allProperties;
    static List<Reservation> reservationList;
    static List<BookingListener> bookingListeners;
    static List<Customer> allCustomers;
    public static void main(String[] args) {

        //Customers creation

        Customer customer = new Customer("1","Nikoleta Kapsali",123566);

        //Τοποθέτηση των πελατών στη λίστα των ενδιαφερομένων

        //Δημιουργία Καταλυμάτων

        Hotel hotel = new Hotel("All blue","Tokyo",120,100,true);
        Apartment apartment = new Apartment("Coral", "Mallorca",300,280,true);

        //Εκτύπωση κρατήσεων

        Reservation reservation = new Reservation(customer,apartment);

        //Εκτύπωση συνολικού κόστους κρατήσεων πελατών

    }

    public void addBookingListener(Customer customer) {
        allCustomers.add(customer);
    }

    public void addProperty(Property property) {
        allProperties.add(property);
    }
    //Η εν λόγω μέθοδος είναι υπεύθυνη για να ενημερώνει όλους τους ενδιαφερόμενους πελάτες για την προσθήκη ενός νέου καταλύματος στο σύστημα
    //Εάν στη μέθοδο αυτή βρεθεί ενδιαφερόμενος πελάτης, την ίδια στιγμή, πραγματοποιείται η κράτηση, κάνοντας κλήση
    //στη μέθοδο makeReservation, με τα στοιχεία του ενδιαφερόμενου πελάτη, καθώς και του καταλύματος

    static void notifyListeners(Property newEntry){
        for (Customer customer : allCustomers) {
            if(newEntry.isAvailable && customer.isInterested(newEntry)) {
                makeReservation(new Reservation(customer, newEntry));
                newEntry.setAvailable(false);
            }
        }

    }

    // This method is responsible for making a reservation for a property by a customer.
    // To do this, it first needs to determine if the property is a hotel or an apartment
    // and then, for hotels, whether there is an available room.
    // Upon making the reservation, the reservation is stored in the reservationList.
    // There is a possibility that we have a hotel where the number of rooms may not be sufficient to accommodate all interested customers.
    // In this particular case, it is not necessary to implement/check within the scope of the exercise. This requires a modification also of the method
    // isInterested, where we have assumed (as a premise) that the reservation will be made, hence the customer's list has been appropriately modified. For the makeReservation

    static void makeReservation(Reservation reservation){
        if(reservation.getProperty() instanceof Hotel) {
            if(((Hotel) reservation.getProperty()).getAvailableRooms() > 0) {
                reservationList.add(reservation);
                System.out.printf("The reservation made for %s at %s%n", reservation.getCustomer().getName(), reservation.getProperty().getName());
            }
        }
    }

    //Στη μέθοδο αυτή θέλουμε σύμφωνα με τα δεδομένα της άσκησης, αλλά και σύμφωνα με την ενδεικτική εκτύπωση,
    //να εκτυπωθούν σε αρχείο και στην κονσόλα (System.out) οι κρατήσεις που έχουν γίνει στο σύστημα
    static void printReservations(){

    }
    //Η μέθοδος αυτή, υπολογίζει και εκτυπώνει το συνολικό κόστος των κρατήσεων που έχουν πραγματοποιηθεί στο σύστημα.
    //Θα χρησιμοποιήσετε τη λίστα reservationList.
    //Uα πρέπει να ελέγξετε τον τύπο του καταλύματος της κράτησης, ώστε στην περίπτωση των ξενοδοχείων να συνυπολογίσετε τυχόν πρωινό,
    //ενώ στην περίπτωση των διαμερισμάτων τυχόν κήπο.
    //Επίσης, θα πρέπει να ελέγξετε πόσες κρατήσεις έχει κάνει ο κάθε πελάτης συνολικά στο σύστημα, ώστε να υπολογιστεί και τυχόν έκπτωση που δικαιούται
    static void calculateReservationCosts(){

    }

}
