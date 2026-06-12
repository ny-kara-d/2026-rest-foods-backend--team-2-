package ch.noseryoung.rest_foods.domains.menu.menuCategory;


import ch.noseryoung.rest_foods.domains.menu.MenuItem.MenuItem;
import ch.noseryoung.rest_foods.domains.menu.MenuItem.menuItemService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Log4j2
@RestController
@RequestMapping("/menu_category")
public class menuCategoryController {


    @Autowired
    menuCategoryService menuCategoryService;

    @Autowired
    menuItemService menuItemService;


    @GetMapping
    ResponseEntity<List<MenuCategory>> getAllMenuCategories() {
        return ResponseEntity.status(200).body(menuCategoryService.getAllMenuCategories());
    }

    @GetMapping("/{menuCategoryId}")
    ResponseEntity<MenuCategory> getMenuCategoryById(@PathVariable UUID menuCategoryId) {
        return ResponseEntity.status(200).body(menuCategoryService.getMenuCategoryById(menuCategoryId));
    }


    @PostMapping
    ResponseEntity<MenuCategory> createMenuCategory(@Valid @RequestBody MenuCategory menuCategory) {
        return ResponseEntity.status(201).body(menuCategoryService.createMenuCategory(menuCategory));
    }


    @PutMapping("/{menuCategoryId}")
    ResponseEntity<MenuCategory> updateMenuCategory(@PathVariable UUID menuCategoryId, @Valid @RequestBody MenuCategory menuCategory) {
        return ResponseEntity.status(200).body(menuCategoryService.updateMenuCategory(menuCategoryId, menuCategory));
    }


    @DeleteMapping("/{menuCategoryId}")
    ResponseEntity<Void> deleteMenu(@PathVariable UUID menuCategoryId) {
        menuCategoryService.deleteMenuCategory(menuCategoryId);
        return ResponseEntity.status(204).build();
    }


    @GetMapping("/{menuCategoryId}/menu-item")
    ResponseEntity<List<MenuItem>> getAllMenuItems(@PathVariable UUID menuCategoryId) {
        return ResponseEntity.status(200).body(menuItemService.getAllMenuItems(menuCategoryId));
    }

    @GetMapping("/{menuCategoryId}/menu-item/{menuItemId}")
    ResponseEntity<MenuItem> getMenuItemById(@PathVariable UUID menuCategoryId, @PathVariable UUID menuItemId) {
        return ResponseEntity.status(200).body(menuItemService.getMenuItemById(menuCategoryId, menuItemId));
    }


    @PostMapping("/{menuCategoryId}/menu-item")
    ResponseEntity<MenuItem> createMenuItem(@PathVariable UUID menuCategoryId, @RequestBody MenuItem menuItem) {
        return ResponseEntity.status(201).body(menuItemService.createMenuItem(menuCategoryId, menuItem));
    }


    @PutMapping("/{menuCategoryId}/menu-item/{menuItemId}")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable UUID menuCategoryId, @RequestBody MenuItem menuItem, @PathVariable UUID menuItemId) {
        return ResponseEntity.status(200).body(menuItemService.updateMenuItem(menuCategoryId, menuItemId, menuItem));
    }


    @DeleteMapping("/{menuCategoryId}/menu-item/{menuItemId}")
    ResponseEntity<Void> deleteMenuItem(@PathVariable UUID menuCategoryId, @PathVariable UUID menuItemId) {
        menuItemService.deleteMenuItem(menuCategoryId, menuItemId);
        return ResponseEntity.status(204).build();
    }

}
