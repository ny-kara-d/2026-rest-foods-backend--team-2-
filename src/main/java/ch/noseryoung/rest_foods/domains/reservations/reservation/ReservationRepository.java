package ch.noseryoung.rest_foods.domains.reservations.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {

    @Query("SELECT r FROM Reservation r WHERE LOWER(r.NameofPerson) LIKE LOWER(CONCAT('%', :NameofPerson, '%'))")
    List<Reservation> findReservationByNameofPerson(@Param("NameofPerson") String NameofPerson);
}
