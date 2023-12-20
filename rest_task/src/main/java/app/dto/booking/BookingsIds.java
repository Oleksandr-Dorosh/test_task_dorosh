package app.dto.booking;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingsIds {
   private long bookingid;
}
