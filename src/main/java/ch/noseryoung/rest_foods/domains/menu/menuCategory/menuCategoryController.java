package ch.noseryoung.rest_foods.domains.menu.menuCategory;


import ch.noseryoung.rest_foods.domains.menu.MenuItem.MenuItem;
import ch.noseryoung.rest_foods.domains.menu.MenuItem.menuItemService;
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
    ResponseEntity<List<MenuCategory>> getAllMenuCategories(@RequestParam(required = true) String menuId) {
        return ResponseEntity.status(200).body(menuCategoryService.getAllMenuCategories());
    }

    @GetMapping("/{menu_id}")
    ResponseEntity<MenuCategory> getMenuCategoryById(@PathVariable UUID menuId) {
        return ResponseEntity.status(200).body(menuCategoryService.getMenuCategoryById(menuId));
    }



    @PostMapping("/")
    ResponseEntity<MenuCategory> createMenuCategory(@RequestBody MenuCategory menuCategory) {
        return ResponseEntity.status(201).body(menuCategoryService.createMenuCategory(menuCategory));
    }


    @PutMapping("/{menu_id}")
    ResponseEntity<MenuCategory> updateMenuCategory(@PathVariable UUID menuId, @RequestBody MenuCategory menuCategory) {
        return ResponseEntity.status(200).body(menuCategoryService.updateMenuCategory(menuId, menuCategory));
    }




    @DeleteMapping
    void deleteMenu(@PathVariable UUID menuId) {
        menuCategoryService.deleteMenuCategory(menuId);
    }









    @GetMapping("/{MenuCategoryId}/menu-item")
    ResponseEntity<List<MenuItem>> getAllMenuItems(@RequestParam(required = true) UUID MenuCategoryId) {
        return ResponseEntity.status(200).body(menuItemService.getAllMenuItems());
    }

    @GetMapping("/{MenuCategoryId}/menu-item/{MenuItemId}")
    ResponseEntity<@Nullable MenuItem> getMenuItemById(@PathVariable UUID MenuItemId, @PathVariable String MenuCategoryId) {
        return ResponseEntity.status(200).body(menuItemService.getMenuItemById(MenuItemId));
    }




    @PostMapping("/{MenuCategoryId}/menu-item")
    ResponseEntity<MenuItem> createMenuItem(@PathVariable UUID MenuCategoryId, @RequestBody MenuItem menuItem) {
        return ResponseEntity.status(201).body(menuItemService.createMenuItem(menuItem));
    }


    @PutMapping("/{MenuCategoryId}/menu-item/{MenuItemId}")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable UUID MenuCategoryId, @RequestBody MenuItem menuItem, @PathVariable UUID MenuItemId) {
        return ResponseEntity.status(200).body(menuItemService.updateMenuItem(MenuItemId, menuItem));
    }


    @DeleteMapping("/{MenuCategoryId}/menu-item/{MenuItemId}")
    void deleteMenuItem(@PathVariable UUID MenuCategoryId, @PathVariable UUID MenuItemId) {
        menuItemService.deleteMenuItem(MenuItemId);
    }

}
