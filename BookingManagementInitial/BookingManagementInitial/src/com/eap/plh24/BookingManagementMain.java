package com.eap.plh24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingManagementMain {
    static List<Property> allProperties = new ArrayList<>();
    static List<Reservation> reservationList = new ArrayList<>();
    static List<BookingListener> bookingListeners = new ArrayList<>();
    static List<Customer> allCustomers = new ArrayList<>();
    private static Map<Customer, Integer> customerBookingCounts = new HashMap<>();
    public static void main(String[] args) {

        //Customers Creation

        Customer customer1 = new Customer("cust1", "John Pappas", 321456789);
        Customer customer2 = new Customer("cust2", "Eftihios Alepis", 123456789);
        Customer customer3 = new Customer("cust3", "Eleni Maniou", 456789123);

        //Τοποθέτηση των πελατών στη λίστα των ενδιαφερομένων

        addBookingListener(customer1);
        addBookingListener(customer2);
        addBookingListener(customer3);

        //Properties Creation

        Hotel hotel1 = new Hotel("Zeus", "Crete", 100, 10, 9,true);
        Hotel hotel2 = new Hotel("Xenia", "Peloponnese", 130, 5, 2,false);
        Apartment apartment1 = new Apartment("Palas", "Macedonia", 200, 100, true);
        Apartment apartment2 = new Apartment("Nestos", "Thrace", 250, 120, false);

        //Reservation print

        addReservation(new Reservation(customer1, hotel1));
        addReservation(new Reservation(customer2, hotel2));
        addReservation(new Reservation(customer2, hotel2)); // the same customer is trying to book the same property
        addReservation(new Reservation(customer3, apartment1));
        addReservation(new Reservation(customer1, apartment2));

        for (Reservation reservation: reservationList) {
            System.out.println(reservation);
        }

        //Εκτύπωση συνολικού κόστους κρατήσεων πελατών

        System.out.println(calculateReservationCosts());

    }

    static public void addReservation(Reservation reservation) {
        reservationList.add(reservation);
        Customer customer = reservation.getCustomer();
        customerBookingCounts.put(customer, customerBookingCounts.getOrDefault(customer, 0) + 1);
    }

    static public void addBookingListener(Customer customer) {
        allCustomers.add(customer);
    }

    static public void addProperty(Property property) {
        allProperties.add(property);
    }
    //Η εν λόγω μέθοδος είναι υπεύθυνη για να ενημερώνει όλους τους ενδιαφερόμενους πελάτες για την προσθήκη ενός νέου καταλύματος στο σύστημα
    //Εάν στη μέθοδο αυτή βρεθεί ενδιαφερόμενος πελάτης, την ίδια στιγμή, πραγματοποιείται η κράτηση, κάνοντας κλήση
    //στη μέθοδο makeReservation, με τα στοιχεία του ενδιαφερόμενου πελάτη, καθώς και του καταλύματος

    static void notifyListeners(Property newEntry){
        for (Customer customer : allCustomers) {
            if(newEntry.isAvailable && customer.isInterested(newEntry)) {
                makeReservation(new Reservation(customer, newEntry));
                if(newEntry instanceof Hotel) {
                    ((Hotel) newEntry).booked();
                    System.out.println("No available rooms");
                }else if (newEntry instanceof Apartment){
                    ((Apartment) newEntry).booked();
                    System.out.println("This apartment is no longer available");
                }

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
            if(reservation.getProperty().isAvailable) {
                reservationList.add(reservation);
                System.out.printf("The reservation made for %s at %s%n", reservation.getCustomer().getName(), reservation.getProperty().getName());
            }
        }
    }

    //Στη μέθοδο αυτή θέλουμε σύμφωνα με τα δεδομένα της άσκησης, αλλά και σύμφωνα με την ενδεικτική εκτύπωση,
    //να εκτυπωθούν σε αρχείο και στην κονσόλα (System.out) οι κρατήσεις που έχουν γίνει στο σύστημα
    static void printReservations(){
        for (Reservation reservation : reservationList) {
            System.out.println(reservation);
        }
    }
    //Η μέθοδος αυτή, υπολογίζει και εκτυπώνει το συνολικό κόστος των κρατήσεων που έχουν πραγματοποιηθεί στο σύστημα.
    //Θα χρησιμοποιήσετε τη λίστα reservationList.
    //Uα πρέπει να ελέγξετε τον τύπο του καταλύματος της κράτησης, ώστε στην περίπτωση των ξενοδοχείων να συνυπολογίσετε τυχόν πρωινό,
    //ενώ στην περίπτωση των διαμερισμάτων τυχόν κήπο.
    //Επίσης, θα πρέπει να ελέγξετε πόσες κρατήσεις έχει κάνει ο κάθε πελάτης συνολικά στο σύστημα, ώστε να υπολογιστεί και τυχόν έκπτωση που δικαιούται

    static double calculateReservationCosts(){
        double totalCost = 0;
        for(Reservation reservation : reservationList) {
            double cost = reservation.getProperty().getCost();
            Customer customer = reservation.getCustomer();

            if(reservation.getProperty() instanceof Hotel){
                if(((Hotel) reservation.getProperty()).isBreakfast()) {
                    cost += 10;
                }

            }else if(reservation.getProperty() instanceof Apartment){
                if((((Apartment) reservation.getProperty()).isGarden())){
                    cost += 20;
                }
            }
            int bookings = customerBookingCounts.getOrDefault(customer, 0);
            double discount = 0;
            if (bookings > 1) {
                discount = bookings >= 3 ? 0.20 : 0.10; // 20% for 3 or more reservations, 10% for 2 reservations
                cost -= cost * discount;
            }
        }
        totalCost += totalCost;
        return totalCost;
    }

}
