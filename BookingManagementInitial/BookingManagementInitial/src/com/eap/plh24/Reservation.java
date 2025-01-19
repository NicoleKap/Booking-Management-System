package com.eap.plh24;

public class Reservation {
    private Customer customer;
    private Property property;

    public Reservation(Customer customer, Property property) {
        this.customer = customer;
        this.property = property;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }


    @Override
    public String toString() {
        return "Reservation{\n" +
                "Customer=" + customer +
                ",\nProperty=" + property +
                '}';
    }
}
