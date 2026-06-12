package ch.noseryoung.rest_foods.domains.reservations.table;

import ch.noseryoung.rest_foods.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class RestaurantTableService {
    @Autowired
    RestaurantTableRepository restaurantTableRepository;

    public List<RestaurantTable> getAllTables() {
        return restaurantTableRepository.findAll();
    }

    public List<RestaurantTable> getAvailableTables(LocalDateTime start, LocalDateTime end) {
        if (!start.isBefore(end)) {
            throw new IllegalArgumentException("Start time must be before end time");
        }

        return restaurantTableRepository.findAvailableTables(start, end);
    }

    public RestaurantTable getTableById(UUID tableId) throws ResourceNotFoundException {
        return restaurantTableRepository.findById(tableId).orElseThrow(() -> new ResourceNotFoundException("Restaurant table with this Id was not found"));
    }

    public RestaurantTable createTable(RestaurantTable restaurantTable) {
        return restaurantTableRepository.save(restaurantTable);
    }

    public RestaurantTable updateTable(UUID tableId, RestaurantTable newTable) throws ResourceNotFoundException {
        RestaurantTable restaurantTable = restaurantTableRepository.findById(tableId).orElseThrow(() -> new ResourceNotFoundException("Restaurant table with this Id was not found"));
        restaurantTable.setChairs(newTable.getChairs());
        return restaurantTableRepository.save(restaurantTable);
    }

    public void deleteTable(UUID tableId) {
        restaurantTableRepository.deleteById(tableId);
    }
}
