package com.codurance.hotel_booking.acceptance;

import com.codurance.hotel_booking.booking.Booking;
import com.codurance.hotel_booking.hotel.Room;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.codurance.hotel_booking.booking.Booking.aBooking;
import static com.codurance.hotel_booking.booking.BookingService.aBookingService;
import static com.codurance.hotel_booking.company.CompanyService.aCompanyService;
import static com.codurance.hotel_booking.hotel.HotelService.aHotelService;
import static org.assertj.core.api.Assertions.assertThat;

class BookRoom {

    private static final long COMPANY_ID = 4l;
    private static final long EMPLOYEE_ID = 5l;
    private static final long HOTEL_ID = 4l;
    private static final Room ROOM_TYPE = Room.JUNIOR_SUITE;
    private static final int QUANTITY = 1;

    @Test
    void when_there_are_no_constraints() {
        aCompanyService().build().addEmployee(COMPANY_ID, EMPLOYEE_ID);
        aHotelService().build().setRoomType(HOTEL_ID, ROOM_TYPE, QUANTITY);
        LocalDate checkInDate = LocalDate.of(2019, 02, 1);

        Booking booking = aBookingService().build().book(EMPLOYEE_ID, HOTEL_ID, ROOM_TYPE, checkInDate, checkInDate.plusDays(1));

        Booking successfulBooking = aBooking()
                .withSuccess()
                .build();
        assertThat(booking).isEqualToComparingFieldByFieldRecursively(successfulBooking);
    }
}