package app.bookingtest;

import app.auth.Authentication;
import app.config.booking.BookingRequest;
import app.dto.auth.AuthDto;
import app.dto.booking.BookingDto;
import app.dto.booking.BookingsIds;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static app.Statuses.SUCCESS;
import static app.TestData.CREATE_DTO;

public class BookingTest {
    private static BookingRequest bookingRequest;
    private static Authentication authentication;
    private static String token;

    @BeforeAll
    private static void setUp() {
        bookingRequest = new BookingRequest();
        authentication = new Authentication();
        String userName = System.getProperty("user_name");
        String password = System.getProperty("password");
        token = authentication.getToken(new AuthDto(userName, password));
    }

    @Test
    public void taskTest() {
        String id = bookingRequest.createBooking(CREATE_DTO)
                .then()
                .statusCode(SUCCESS)
                .extract()
                .jsonPath()
                .getString("bookingid");

        BookingDto actualDto = bookingRequest.getBookingById(id)
                .then()
                .statusCode(SUCCESS)
                .extract()
                .as(BookingDto.class);
        Assertions.assertEquals(CREATE_DTO, actualDto);

        CREATE_DTO.setTotalprice(113.0D);
        Map<String, Object> updateMap = new HashMap<>();
        updateMap.put("totalprice", 113.0D);
        BookingDto actualDtoAfterUpdate = bookingRequest
                .patchBookingById(id, updateMap, token)
                .then()
                .statusCode(SUCCESS)
                .extract()
                .as(BookingDto.class);
        Assertions.assertEquals(CREATE_DTO, actualDtoAfterUpdate);

        List<Long> allBooking = bookingRequest
                .getAllBooking()
                .then()
                .statusCode(SUCCESS)
                .extract()
                .body()
                .jsonPath()
                .getList(".", BookingsIds.class)
                .stream()
                .map(BookingsIds::getBookingid)
                .collect(Collectors.toList());

        Assertions.assertTrue(allBooking.contains(Long.valueOf(id)));
        bookingRequest.deleteBookingById(id);
    }
}
