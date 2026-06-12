package ch.noseryoung.rest_foods.domains.reservations.table;

import ch.noseryoung.rest_foods.Exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tables")
public class RestaurantTableController {

    @Autowired
    RestaurantTableService restaurantTableService;

    @GetMapping("")
    ResponseEntity<List<RestaurantTable>> getAllTables(@RequestParam(required = false) LocalDateTime start, @RequestParam(required = false) LocalDateTime end) {
        if (start != null && end != null) {
            return ResponseEntity.status(200).body(restaurantTableService.getAvailableTables(start, end));
        }

        return ResponseEntity.status(200).body(restaurantTableService.getAllTables());
    }

    @GetMapping("/{table_id}")
    ResponseEntity<RestaurantTable> getTableById(@PathVariable UUID table_id) throws ResourceNotFoundException {
        return ResponseEntity.status(200).body(restaurantTableService.getTableById(table_id));
    }

    @PostMapping
    ResponseEntity<RestaurantTable> createTable(@Valid @RequestBody RestaurantTable restaurantTable) {
        return ResponseEntity.status(201).body(restaurantTableService.createTable(restaurantTable));
    }

    @PutMapping("{table_id}")
    ResponseEntity<RestaurantTable> updateTable(@PathVariable UUID table_id, @Valid @RequestBody RestaurantTable newTable) throws ResourceNotFoundException {
        return ResponseEntity.status(200).body(restaurantTableService.updateTable(table_id, newTable));
    }

    @DeleteMapping("{table_id}")
    ResponseEntity<Void> deleteTable(@PathVariable UUID table_id) {
        restaurantTableService.deleteTable(table_id);
        return ResponseEntity.status(204).build();
    }


}
