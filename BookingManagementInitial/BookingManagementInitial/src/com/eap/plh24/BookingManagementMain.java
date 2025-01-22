package com.eap.plh24;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

        Customer customer1 = new Customer("cust1", "Eftihios Alepis", 123456789);
        Customer customer2 = new Customer("cust2", "John Pappas", 321456789);
        Customer customer3 = new Customer("cust3", "Eleni Maniou", 456789123);

        //Τοποθέτηση των πελατών στη λίστα των ενδιαφερομένων

        addBookingListener(customer1);
        addBookingListener(customer2);
        addBookingListener(customer3);



        //Properties Creation

        // 2 Hotels

        Hotel hotel1 = new Hotel("Zeus", "Crete", 100, 10, 9,true);
        Hotel hotel2 = new Hotel("Xenia", "Peloponnese", 130, 5, 2,false);

        // 3 Apartments

        Apartment apartment1 = new Apartment("Palas", "Macedonia", 200, 100, true);
        Apartment apartment2 = new Apartment("Nestos", "Thrace", 250, 120, false);
        Apartment apartment3 = new Apartment("Pegasus", "Peloponnese", 180, 80, false);

        customer1.addInterested(hotel1);

        //Reservation print

        addReservation(new Reservation(customer2, hotel1));
        addReservation(new Reservation(customer1, hotel2));
        addReservation(new Reservation(customer2, hotel2)); // the same customer is trying to book the same property
        addReservation(new Reservation(customer3, hotel2));
        addReservation(new Reservation(customer1, apartment1));
        addReservation(new Reservation(customer2,apartment2));

       printReservations();

        //Print the Total Cost of Reservations

        System.out.printf("Total cost: %s%n", calculateReservationCosts());

        // Print the interestedFor

        System.out.println("=====================================================================================================================");
        customer1.addInterested(hotel2);
        customer1.addInterested(apartment1);
        customer1.isInterested(hotel2);
        customer1.isInterested(apartment1);
        System.out.println("=====================================================================================================================");
        customer2.addInterested(hotel1);
        customer2.isInterested(hotel2);
        customer2.addInterested(apartment2);
        customer2.isInterested(apartment2);
        System.out.println("=====================================================================================================================");
        customer3.addInterested(new Hotel("Thessalia"));
        customer3.isInterested(new Hotel("Thessalia"));
        customer3.addInterested(apartment3);
        customer3.isInterested(apartment3);


    }

    static public void addReservation(Reservation reservation) {
        int newId = 1;
        if(!reservationList.isEmpty()) {
            newId = reservationList.getLast().getId() + 1;
        }
        reservation.setId(newId);
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
    // This method is responsible for notifying all interested customers about the addition of a new property to the system.
    // If an interested customer is found in this method, a reservation is made immediately,
    // calling the makeReservation method with the details of the interested customer and the property.

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

    // In this method, according to the exercise data and the sample printout,
    // we want to print the reservations that have been made in the system to a file and to the console (System.out).

    static void printReservations(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt"))) {
            for (Reservation reservation : reservationList) {
                writer.write(reservation.toString());
                writer.newLine();  // Every reservation in a new line
            }
        } catch (IOException e) {
            System.err.printf("Error writing to the file: %s%n", e.getMessage());
        }
        // Print to the console
        for (Reservation reservation : reservationList) {
            System.out.println(reservation);
        }
    }
    // This method calculates and prints the total cost of the reservations that have been made in the system.
    // You will use the reservationList.
    // You need to check the type of property for each reservation, so that in the case of hotels, any breakfast is included in the calculation,
    // and in the case of apartments, any garden is considered.
    // Also, you must check how many reservations each customer has made in total in the system to calculate any discount they are entitled to.

    static double calculateReservationCosts() {
        double totalCost = 0;
        for (Reservation reservation : reservationList) {
            double cost = reservation.getProperty().getCost();
            Customer customer = reservation.getCustomer();

            if (reservation.getProperty() instanceof Hotel) {
                if (((Hotel) reservation.getProperty()).isBreakfast()) {
                    cost += 10;
                }

            } else if (reservation.getProperty() instanceof Apartment) {
                if ((((Apartment) reservation.getProperty()).isGarden())) {
                    cost += 20;
                }
            }
            int bookings = customerBookingCounts.getOrDefault(customer, 0);
            double discount = 0;
            if (bookings > 1) {
                discount = bookings >= 3 ? 0.20 : 0.10; // 20% for 3 or more reservations, 10% for 2 reservations
                cost -= cost * discount;
            }
            totalCost += cost;
        }

        return totalCost;
    }

}
