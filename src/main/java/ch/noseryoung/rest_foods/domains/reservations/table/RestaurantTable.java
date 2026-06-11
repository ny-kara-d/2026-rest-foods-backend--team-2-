package ch.noseryoung.rest_foods.domains.reservations.table;

import ch.noseryoung.rest_foods.domains.reservations.reservation.Reservation;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestaurantTable {
    @Column(unique = true, nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID TableId;

    @NotNull(message = "Can't be null")
    @Min(value = 2, message = "A table has to have at least 2 Chairs")
    int Chairs;

    @OneToMany(mappedBy = "restaurantTable", orphanRemoval = true)
    private Set<Reservation> reservations = new LinkedHashSet<>();

}
