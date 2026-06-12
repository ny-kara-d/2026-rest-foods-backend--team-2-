package ch.noseryoung.rest_foods.domains.reservations.reservation;

import ch.noseryoung.rest_foods.domains.reservations.table.RestaurantTable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reservation {
    @Column(unique = true, nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID reservationId;

    @Future(message = "Date must be in the Future")
    @NotNull(message = "Can't be null")
    LocalDateTime startingTime;

    @Future(message = "Date must be in the Future")
    @NotNull(message = "Can't be null")
    LocalDateTime endingTime;

    @Positive(message = "Must be Positive")
    @Min(value = 1, message = "At least 1 Person is required")
    @Column(nullable = false)
    Integer amountOfPersons;

    @NotBlank(message = "Can't be blank")
    @NotNull(message = "Can't be null")
    String phoneNumber;

    @Size(max = 50, message = "Name can't be longer than 50 chars")
    @NotBlank(message = "Can't be blank")
    @NotNull(message = "Can't be null")
    String nameofPerson;

    @NotNull
    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("reservations")
    private RestaurantTable restaurantTable;

}
