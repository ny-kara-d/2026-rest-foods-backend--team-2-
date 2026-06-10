package ch.noseryoung.rest_foods.domains.reservations.reservation;

import ch.noseryoung.rest_foods.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations(String NameofPerson) {
        if (NameofPerson == null || NameofPerson.isBlank()) {
            return reservationRepository.findAll();
        }
        return reservationRepository.findReservationByNameofPerson(NameofPerson);
    }

    public Reservation getReservationById(UUID reservation_id) throws ResourceNotFoundException {
        return reservationRepository.findById(reservation_id).orElseThrow(() -> new ResourceNotFoundException("Reservation with this Id was not found"));
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }


    public Reservation updateReservation(UUID reservation_id, Reservation newReservation) throws ResourceNotFoundException {
        Reservation reservation = reservationRepository.findById(reservation_id).orElseThrow(() -> new ResourceNotFoundException("Reservation with this Id was not found"));
        reservation.setStartingTime(newReservation.getStartingTime());
        reservation.setEndingTime(newReservation.getEndingTime());
        reservation.setNameofPerson(newReservation.getNameofPerson());
        reservation.setPhoneNumber(newReservation.getPhoneNumber());
        reservation.setAmountOfPersons(newReservation.getAmountOfPersons());
        reservation.setRestaurantTable(newReservation.getRestaurantTable());
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(UUID reservation_id) {
        reservationRepository.deleteById(reservation_id);
    }


}
