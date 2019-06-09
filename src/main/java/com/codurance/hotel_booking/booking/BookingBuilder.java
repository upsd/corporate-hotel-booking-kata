package com.codurance.hotel_booking.booking;

public class BookingBuilder {

    public BookingBuilder withSuccess() {
        return this;
    }

    public Booking build() {
        return new Booking();
    }
}
