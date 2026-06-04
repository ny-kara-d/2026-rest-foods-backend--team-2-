package ch.noseryoung.rest_foods.domains.reservations.reservation;

import jakarta.validation.Valid;
import org.apache.coyote.Response;
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
    ResponseEntity<List<Reservation>> getAllReservations(@RequestParam(required = false) String name) {
        return ResponseEntity.status(200).body(reservationService.getAllReservations());
    }

    @GetMapping("/{reservation_id}")
    ResponseEntity<Reservation> getReservationById(@PathVariable UUID reservation_id) throws Exception {
        return ResponseEntity.status(200).body(reservationService.getReservationbyId(reservation_id));
    }

    @PostMapping("/")
    ResponseEntity<Reservation> createReservation(@Valid @RequestBody Reservation reservation) {
        return ResponseEntity.status(201).body(reservationService.createReservation(reservation));
    }

    @PutMapping("{reservation_id}")
    ResponseEntity<Reservation> updateReservation(@PathVariable UUID reservation_id, @Valid @RequestBody Reservation newReservation) throws Exception {
        return ResponseEntity.status(200).body(reservationService.updateReservation(reservation_id, newReservation));
    }

    @DeleteMapping("{reservation_id}")
    void deleteReservation(@PathVariable UUID reservation_id) throws Exception {
        reservationService.deleteReservation(reservation_id);
    }


}
