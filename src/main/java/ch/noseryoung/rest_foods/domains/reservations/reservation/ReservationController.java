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


    @GetMapping("")
    ResponseEntity<List<Reservation>> getAllReservations(@RequestParam(required = false) String NameofPerson) {
        return ResponseEntity.status(200).body(reservationService.getAllReservations(NameofPerson));
    }

    @GetMapping("/{reservation_id}")
    ResponseEntity<Reservation> getReservationById(@PathVariable UUID reservation_id) throws ResourceNotFoundException {
        return ResponseEntity.status(200).body(reservationService.getReservationById(reservation_id));
    }

    @PostMapping("/")
    ResponseEntity<Reservation> createReservation(@Valid @RequestBody Reservation reservation) {
        return ResponseEntity.status(201).body(reservationService.createReservation(reservation));
    }

    @PutMapping("{reservation_id}")
    ResponseEntity<Reservation> updateReservation(@PathVariable UUID reservation_id, @Valid @RequestBody Reservation newReservation) throws ResourceNotFoundException {
        return ResponseEntity.status(200).body(reservationService.updateReservation(reservation_id, newReservation));
    }

    @DeleteMapping("{reservation_id}")
    void deleteReservation(@PathVariable UUID reservation_id) {
        reservationService.deleteReservation(reservation_id);
    }


}
