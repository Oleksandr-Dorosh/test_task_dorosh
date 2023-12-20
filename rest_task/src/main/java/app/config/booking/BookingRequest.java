package app.config.booking;

import app.config.BaseHttpRequest;
import app.dto.booking.BookingDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import java.util.Map;

public class BookingRequest extends BaseHttpRequest {

    private static final String BOOKING = "booking/";
    private ObjectMapper objectMapper = new ObjectMapper();

    public Response getBookingById(String id) {
        return getRequestSpecification()
                .get(BOOKING + id);
    }

    public Response createBooking(BookingDto bookingDto) {
        return getRequestSpecification()
                .body(bookingDto)
                .post(BOOKING);
    }

    public Response updateBookingById(String id, BookingDto bookingDto, String token) {
        return getRequestSpecification()
                .header("Cookie", "token=" + token)
                .body(bookingDto)
                .put(BOOKING + id);

    }

    public Response patchBookingById(String id, Map<String, Object> map, String token) {
        try {
            return getRequestSpecification()
                    .header("Cookie", "token=" + token)
                    .body(objectMapper.writeValueAsString(map))
                    .patch(BOOKING + id);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public Response deleteBookingById(String id) {
        return getRequestSpecification()
                .delete(BOOKING + id);
    }

    public Response getAllBooking() {
        return getRequestSpecification()
                .get(BOOKING);
    }
}
