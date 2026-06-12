package ch.noseryoung.rest_foods.domains.reservations.reservation;

import ch.noseryoung.rest_foods.Exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    ReservationService reservationService;


    @GetMapping()
    ResponseEntity<List<Reservation>> getAllReservations(@RequestParam(required = false) String nameofPerson) {
        return ResponseEntity.status(200).body(reservationService.getAllReservations(nameofPerson));
    }

    @GetMapping("/{reservationId}")
    ResponseEntity<Reservation> getReservationById(@PathVariable UUID reservationId) throws ResourceNotFoundException {
        return ResponseEntity.status(200).body(reservationService.getReservationById(reservationId));
    }

    @PostMapping()
    ResponseEntity<Reservation> createReservation(@Valid @RequestBody Reservation reservation) {
        return ResponseEntity.status(201).body(reservationService.createReservation(reservation));
    }

    @PutMapping("/{reservationId}")
    ResponseEntity<Reservation> updateReservation(@PathVariable UUID reservationId, @Valid @RequestBody Reservation newReservation) throws ResourceNotFoundException {
        return ResponseEntity.status(200).body(reservationService.updateReservation(reservationId, newReservation));
    }

    @DeleteMapping("/{reservationId}")
    ResponseEntity<Void> deleteReservation(@PathVariable UUID reservationId) {
        reservationService.deleteReservation(reservationId);
        return ResponseEntity.status(204).build();
    }


}
