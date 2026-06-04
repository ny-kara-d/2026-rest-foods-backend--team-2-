package ch.noseryoung.rest_foods.domains.reservations.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReservationService {
    @Autowired ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }

    public Reservation getReservationbyId(UUID reservation_id) throws Exception {
        return reservationRepository.findById(reservation_id).orElseThrow(() -> new Exception("Reservation with this Id was not found")) ;
    }

}
