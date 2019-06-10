package com.codurance.hotel_booking.booking;

import com.codurance.hotel_booking.company.CompanyService;
import com.codurance.hotel_booking.hotel.HotelService;
import com.codurance.hotel_booking.hotel.Room;

import java.time.LocalDate;

public class BookingService {

    BookingService(CompanyService companyService, HotelService hotelService) {

    }

    public static BookingServiceBuilder aBookingService() {
        return new BookingServiceBuilder();
    }

    public Booking book(long employeeId, long hotelId, Room roomType, LocalDate checkInDate, LocalDate checkOutDate) {
        return null;
    }
}
