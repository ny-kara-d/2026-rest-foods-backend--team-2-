package ch.noseryoung.rest_foods.domains.reservations.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RestaurantTableService {
    @Autowired
    RestaurantTableRepository restaurantTableRepository;

    public List<RestaurantTable> getAllTables() {
        return restaurantTableRepository.findAll();
    }

    public RestaurantTable getTableById(UUID table_id) throws Exception {
        return restaurantTableRepository.findById(table_id).orElseThrow(() -> new Exception("Restaurant table with this Id was not found"));
    }

    public RestaurantTable createTable(RestaurantTable restaurantTable) {
        return restaurantTableRepository.save(restaurantTable);
    }

    public RestaurantTable updateTable(UUID table_id, RestaurantTable newTable) throws Exception {
        RestaurantTable restaurantTable = restaurantTableRepository.findById(table_id) .orElseThrow(() -> new Exception("Restaurant table with this Id was not found"));
        restaurantTable.setChairs(newTable.getChairs());
        return restaurantTableRepository.save(restaurantTable);
    }

    public void deleteTable(UUID table_id) {
        restaurantTableRepository.deleteById(table_id);
    }
}
