package app.dto.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingDates {
    private String checkin;
    private String checkout;

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BookingDates)) return false;
        final BookingDates other = (BookingDates) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$checkin = this.getCheckin();
        final Object other$checkin = other.getCheckin();
        if (this$checkin == null ? other$checkin != null : !this$checkin.equals(other$checkin)) return false;
        final Object this$checkout = this.getCheckout();
        final Object other$checkout = other.getCheckout();
        if (this$checkout == null ? other$checkout != null : !this$checkout.equals(other$checkout)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BookingDates;
    }
}
