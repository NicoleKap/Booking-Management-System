package com.eap.plh24;

public class Reservation {
    private Customer customer;
    private Property property;
    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + ". Reservation{\nCustomer=%s,\nProperty=%s}".formatted(customer, property);
    }
}
