package ch.noseryoung.rest_foods.domains.reservations.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {

    @Query("SELECT r FROM Reservation r WHERE LOWER(r.nameofPerson) LIKE LOWER(CONCAT('%', :nameofPerson, '%'))")
    List<Reservation> findReservationByNameofPerson(@Param("nameofPerson") String nameofPerson);

    @Query("""
            SELECT COUNT(r) > 0 FROM Reservation r
            WHERE r.restaurantTable.tableId = :tableId
            AND r.startingTime < :end
            AND r.endingTime > :start
            """)
    boolean existsOverlappingReservation(
            @Param("tableId") UUID tableId,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );

    @Query("""
            SELECT COUNT(r) > 0 FROM Reservation r
            WHERE r.restaurantTable.tableId = :tableId
            AND r.reservationId <> :reservationId
            AND r.startingTime < :end
            AND r.endingTime > :start
            """)
    boolean existsOverlappingReservationExcludingReservation(
            @Param("tableId") UUID tableId,
            @Param("reservationId") UUID reservationId,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );
}
