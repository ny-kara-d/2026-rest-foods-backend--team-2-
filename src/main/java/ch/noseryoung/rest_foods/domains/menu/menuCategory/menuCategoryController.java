package ch.noseryoung.rest_foods.domains.menu.menuCategory;

import ch.noseryoung.rest_foods.domains.menu.MenuItem.MenuItem;
import ch.noseryoung.rest_foods.domains.menu.MenuItem.menuItemService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.jspecify.annotations.Nullable;
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

    @GetMapping("/{menuId}")
    ResponseEntity<MenuCategory> getMenuCategoryById(@PathVariable UUID menuId) {
        return ResponseEntity.status(200).body(menuCategoryService.getMenuCategoryById(menuId));
    }

    @PostMapping("/")
    ResponseEntity<MenuCategory> createMenuCategory(@Valid @RequestBody MenuCategory menuCategory) {
        return ResponseEntity.status(201).body(menuCategoryService.createMenuCategory(menuCategory));
    }

    @PutMapping("/{menuId}")
    ResponseEntity<MenuCategory> updateMenuCategory(@PathVariable UUID menuId, @Valid @RequestBody MenuCategory menuCategory) {
        return ResponseEntity.status(200).body(menuCategoryService.updateMenuCategory(menuId, menuCategory));
    }

    @DeleteMapping("/{menuId}")
    void deleteMenu(@PathVariable UUID menuId) {
        menuCategoryService.deleteMenuCategory(menuId);
    }

    @GetMapping("/{menuCategoryId}/menu-item")
    ResponseEntity<List<MenuItem>> getAllMenuItems(@PathVariable UUID menuCategoryId) {
        return ResponseEntity.status(200).body(menuItemService.getAllMenuItems(menuCategoryId));
    }

    @GetMapping("/{menuCategoryId}/menu-item/{menuItemId}")
    ResponseEntity<@Nullable MenuItem> getMenuItemById(@PathVariable UUID menuCategoryId, @PathVariable UUID menuItemId) {
        return ResponseEntity.status(200).body(menuItemService.getMenuItemById(menuItemId));
    }

    @PostMapping("/{menuCategoryId}/menu-item")
    ResponseEntity<MenuItem> createMenuItem(@PathVariable UUID menuCategoryId, @RequestBody MenuItem menuItem) {
        return ResponseEntity.status(201).body(menuItemService.createMenuItem(menuCategoryId, menuItem));
    }

    @PutMapping("/{menuCategoryId}/menu-item/{menuItemId}")
    ResponseEntity<MenuItem> updateMenuItem(@PathVariable UUID menuCategoryId, @PathVariable UUID menuItemId, @RequestBody MenuItem menuItem) {
        return ResponseEntity.status(200).body(menuItemService.updateMenuItem(menuCategoryId, menuItemId, menuItem));
    }

    @DeleteMapping("/{menuCategoryId}/menu-item/{menuItemId}")
    void deleteMenuItem(@PathVariable UUID menuCategoryId, @PathVariable UUID menuItemId) {
        menuItemService.deleteMenuItem(menuItemId);
    }
}
