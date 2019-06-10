package com.codurance.hotel_booking.booking;

import com.codurance.hotel_booking.company.CompanyService;
import com.codurance.hotel_booking.hotel.HotelService;

public class BookingServiceBuilder {

    private CompanyService companyService;
    private HotelService hotelService;

    public BookingServiceBuilder() {
        this.companyService = CompanyService.aCompanyService().build();
        this.hotelService = HotelService.aHotelService().build();
    }

    public BookingServiceBuilder withCompanyService(CompanyService companyService) {
        this.companyService = companyService;
        return this;
    }

    public BookingServiceBuilder withHotelService(HotelService hotelService) {
        this.hotelService = hotelService;
        return this;
    }

    public BookingService build() {
        return new BookingService(companyService, hotelService);
    }
}
