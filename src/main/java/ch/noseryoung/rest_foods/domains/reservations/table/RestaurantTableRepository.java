package ch.noseryoung.rest_foods.domains.reservations.table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, UUID> {
    @Query("""
            SELECT t FROM RestaurantTable t
            WHERE NOT EXISTS (
                SELECT r FROM Reservation r
                WHERE r.restaurantTable = t
                AND r.startingTime < :end
                AND r.endingTime > :start
            )
            """)
    List<RestaurantTable> findAvailableTables(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}
