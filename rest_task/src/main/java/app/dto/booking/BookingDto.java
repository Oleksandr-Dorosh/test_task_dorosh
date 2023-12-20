package app.dto.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingDto {
    private String firstname;
    private String lastname;
    private Double totalprice;
    private Boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BookingDto)) return false;
        final BookingDto other = (BookingDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$firstname = this.getFirstname();
        final Object other$firstname = other.getFirstname();
        if (this$firstname == null ? other$firstname != null : !this$firstname.equals(other$firstname)) return false;
        final Object this$lastname = this.getLastname();
        final Object other$lastname = other.getLastname();
        if (this$lastname == null ? other$lastname != null : !this$lastname.equals(other$lastname)) return false;
        final Object this$totalprice = this.getTotalprice();
        final Object other$totalprice = other.getTotalprice();
        if (this$totalprice == null ? other$totalprice != null : !this$totalprice.equals(other$totalprice))
            return false;
        final Object this$depositpaid = this.getDepositpaid();
        final Object other$depositpaid = other.getDepositpaid();
        if (this$depositpaid == null ? other$depositpaid != null : !this$depositpaid.equals(other$depositpaid))
            return false;
        final Object this$bookingdates = this.getBookingdates();
        final Object other$bookingdates = other.getBookingdates();
        if (this$bookingdates == null ? other$bookingdates != null : !this$bookingdates.equals(other$bookingdates))
            return false;
        final Object this$additionalneeds = this.getAdditionalneeds();
        final Object other$additionalneeds = other.getAdditionalneeds();
        if (this$additionalneeds == null ? other$additionalneeds != null : !this$additionalneeds.equals(other$additionalneeds))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BookingDto;
    }

}
