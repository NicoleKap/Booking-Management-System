package com.eap.plh24;

import java.util.ArrayList;
import java.util.List;

// Interface for reservation listeners
interface BookingListener {
    boolean isInterested(Property property);
    void makeReservation(Property property);

}

