package app;

import app.dto.booking.BookingDates;
import app.dto.booking.BookingDto;

public interface TestData {
    String NAME = "Jessica";
    String LAST_NAME = "Kallen";
    Double TOTAL_PRICE = 112.0D;
    Boolean DEPOSIT = true;
    String ADDITIONAL_REQUIREMENTS = "Breakfast";
    String CHECK_IN = "2024-12-12";
    String CHECK_OUT = "2024-12-15";

    BookingDto CREATE_DTO = new BookingDto(NAME, LAST_NAME, TOTAL_PRICE, DEPOSIT,
            new BookingDates(CHECK_IN, CHECK_OUT), ADDITIONAL_REQUIREMENTS);

}
