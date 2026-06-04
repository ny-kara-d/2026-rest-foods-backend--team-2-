package ch.noseryoung.rest_foods.domains.reservations.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired ReservationService reservationService;


    @GetMapping("")
    ResponseEntity<List<Reservation>> getAllReservations(@RequestParam(required = false) String name){
        return ResponseEntity.status(200).body(reservationService.getAllReservations());
    }

    @GetMapping("/{reservation_id}")
    ResponseEntity<Reservation> getReservationById(@PathVariable UUID reservation_id) throws Exception {
        return ResponseEntity.status(200).body(reservationService.getReservationbyId(reservation_id));
    }


}
