package com.codurance.hotel_booking.acceptance;

import com.codurance.hotel_booking.booking.Booking;
import com.codurance.hotel_booking.booking.BookingService;
import com.codurance.hotel_booking.booking_policy.BookingPolicyService;
import com.codurance.hotel_booking.company.CompanyService;
import com.codurance.hotel_booking.hotel.HotelService;
import com.codurance.hotel_booking.hotel.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.codurance.hotel_booking.booking.Booking.aBooking;
import static com.codurance.hotel_booking.booking.BookingService.aBookingService;
import static com.codurance.hotel_booking.booking_policy.BookingPolicyService.aBookingPolicyService;
import static com.codurance.hotel_booking.company.CompanyService.aCompanyService;
import static com.codurance.hotel_booking.hotel.HotelService.aHotelService;
import static org.assertj.core.api.Assertions.assertThat;

class BookRoom {

    private static final long COMPANY_ID = 4l;
    private static final long EMPLOYEE_ID = 5l;
    private static final long HOTEL_ID = 4l;
    private static final Room ROOM_TYPE = Room.JUNIOR_SUITE;
    private static final int QUANTITY = 1;
    private CompanyService companyService;
    private HotelService hotelService;
    private BookingPolicyService bookingPolicyService;
    private BookingService bookingService;

    @BeforeEach
    void setUp() {
        companyService = aCompanyService().build();
        hotelService = aHotelService().build();
        bookingPolicyService = aBookingPolicyService().build();

        bookingService = aBookingService()
                .withCompanyService(companyService)
                .withHotelService(hotelService)
                .withBookingPolicyService(bookingPolicyService)
                .build();
    }

    @Test
    void when_there_are_no_constraints() {
        companyService.addEmployee(COMPANY_ID, EMPLOYEE_ID);
        hotelService.setRoomType(HOTEL_ID, ROOM_TYPE, QUANTITY);
        bookingPolicyService.setEmployeePolicy(EMPLOYEE_ID, ROOM_TYPE);
        LocalDate checkInDate = LocalDate.of(2019, 02, 1);

        Booking booking = bookingService.book(EMPLOYEE_ID, HOTEL_ID, ROOM_TYPE, checkInDate, checkInDate.plusDays(1));

        Booking successfulBooking = aBooking()
                .withSuccess()
                .build();
        assertThat(booking).isEqualToComparingFieldByFieldRecursively(successfulBooking);
    }
}
