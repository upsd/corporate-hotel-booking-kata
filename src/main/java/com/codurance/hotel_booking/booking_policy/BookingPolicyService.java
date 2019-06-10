package com.codurance.hotel_booking.booking_policy;

import com.codurance.hotel_booking.hotel.Room;

public class BookingPolicyService {

    public static BookingPolicyBuilder aBookingPolicyService() {
        return new BookingPolicyBuilder();
    }

    public void setEmployeePolicy(long employeeId, Room roomType) {

    }
}
