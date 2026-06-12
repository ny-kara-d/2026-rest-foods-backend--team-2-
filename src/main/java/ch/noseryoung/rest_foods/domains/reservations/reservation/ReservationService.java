package ch.noseryoung.rest_foods.domains.reservations.reservation;

import ch.noseryoung.rest_foods.Exceptions.ResourceNotFoundException;
import ch.noseryoung.rest_foods.domains.reservations.table.RestaurantTable;
import ch.noseryoung.rest_foods.domains.reservations.table.RestaurantTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    RestaurantTableRepository restaurantTableRepository;

    public List<Reservation> getAllReservations(String nameofPerson) {
        if (nameofPerson == null || nameofPerson.isBlank()) {
            return reservationRepository.findAll();
        }
        return reservationRepository.findReservationByNameofPerson(nameofPerson);
    }

    public Reservation getReservationById(UUID reservationId) throws ResourceNotFoundException {
        return reservationRepository.findById(reservationId).orElseThrow(() -> new ResourceNotFoundException("Reservation with this Id was not found"));
    }

    public Reservation createReservation(Reservation reservation) throws ResourceNotFoundException {
        RestaurantTable table = validateReservation(reservation, null);
        reservation.setRestaurantTable(table);
        return reservationRepository.save(reservation);
    }


    public Reservation updateReservation(UUID reservationId, Reservation newReservation) throws ResourceNotFoundException {
        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(() -> new ResourceNotFoundException("Reservation with this Id was not found"));
        RestaurantTable table = validateReservation(newReservation, reservationId);
        reservation.setStartingTime(newReservation.getStartingTime());
        reservation.setEndingTime(newReservation.getEndingTime());
        reservation.setNameofPerson(newReservation.getNameofPerson());
        reservation.setPhoneNumber(newReservation.getPhoneNumber());
        reservation.setAmountOfPersons(newReservation.getAmountOfPersons());
        reservation.setRestaurantTable(table);
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(UUID reservationId) {
        if (!reservationRepository.existsById(reservationId)) {
            throw new ResourceNotFoundException("Reservation with this Id was not found");
        }
        reservationRepository.deleteById(reservationId);
    }

    private RestaurantTable validateReservation(Reservation reservation, UUID reservationIdToIgnore) throws ResourceNotFoundException {
        if (!reservation.getStartingTime().isBefore(reservation.getEndingTime())) {
            throw new IllegalArgumentException("Start time must be before end time");
        }

        if (reservation.getRestaurantTable() == null || reservation.getRestaurantTable().getTableId() == null) {
            throw new IllegalArgumentException("A restaurant table is required");
        }

        UUID tableId = reservation.getRestaurantTable().getTableId();
        RestaurantTable table = restaurantTableRepository.findById(tableId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant table with this Id was not found"));

        if (reservation.getAmountOfPersons() > table.getChairs()) {
            throw new IllegalArgumentException("Amount of persons must be smaller than or equal to the number of chairs");
        }

        boolean hasOverlappingReservation = reservationIdToIgnore == null
                ? reservationRepository.existsOverlappingReservation(tableId, reservation.getStartingTime(), reservation.getEndingTime())
                : reservationRepository.existsOverlappingReservationExcludingReservation(tableId, reservationIdToIgnore, reservation.getStartingTime(), reservation.getEndingTime());

        if (hasOverlappingReservation) {
            throw new IllegalArgumentException("This table is already reserved for the selected time");
        }

        return table;
    }

}
