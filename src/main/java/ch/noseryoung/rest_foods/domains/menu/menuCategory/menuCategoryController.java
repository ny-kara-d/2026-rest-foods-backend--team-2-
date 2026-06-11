package ch.noseryoung.rest_foods.domains.menu.menuCategory;


import ch.noseryoung.rest_foods.domains.menu.MenuItem.MenuItem;
import ch.noseryoung.rest_foods.domains.menu.MenuItem.menuItemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Log4j2
@RestController
@RequestMapping("/menu_category")
public class menuCategoryController {



    @Autowired
    menuCategoryService menuCategoryService;

    @Autowired
    menuItemService menuItemService;


//done




    @GetMapping
    ResponseEntity<List<MenuCategory>> getAllMenuCategories(@RequestParam(required = true) String menuId) {
        return ResponseEntity.status(200).body(menuCategoryService.getAllMenuCategories());
    }
//done
    @GetMapping("/{menu_id}")
    ResponseEntity<MenuCategory> getMenuCategoryById(@PathVariable UUID menuId) {
        return ResponseEntity.status(200).body(menuCategoryService.getMenuCategoryById());
    }


//done
    @PostMapping("/")
    ResponseEntity<MenuCategory> createMenuCategory(@RequestBody MenuCategory menuCategory) {
        return ResponseEntity.status(201).body(menuCategoryService.createMenuCategory());
    }

//done
    @PutMapping("/{menu_id}")
    ResponseEntity<MenuCategory> updateMenuCategory(@PathVariable UUID menuId, @RequestBody MenuCategory menuCategory) {
        return ResponseEntity.status(200).body(menuCategoryService.updateMenuCategory());
    }




    @DeleteMapping
    void deleteMenu(@PathVariable UUID menuId) {
        menuCategoryService.deleteMenuCategory(menuId);
    }








    //done
    @GetMapping("/{MenuCategoryId}/menu-item")
    ResponseEntity<List<MenuItem>> getAllMenuItems(@RequestParam(required = true) UUID MenuCategoryId) {
        return ResponseEntity.status(200).body(menuItemService.getAllMenuItems());
    }

    @GetMapping("/{MenuCategoryId}/menu-item/{MenuItemId}")
    ResponseEntity<Optional<MenuItem>> getMenuItemById(@PathVariable UUID MenuItemId, @PathVariable String MenuCategoryId) {
        return ResponseEntity.status(200).body(menuItemService.getMenuItemById(MenuItemId));
    }
    //.this again instead?


//done
    @PostMapping("/{MenuCategoryId}/menu-item")
    ResponseEntity<MenuItem> createMenuItem(@PathVariable UUID MenuCategoryId, @RequestBody MenuItem menuItem) {
        return ResponseEntity.status(201).body(menuItemService.createMenuItem(menuItem));
    }

    //put
    @PutMapping("/{MenuCategoryId}/menu-item/{MenuItemId}")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable UUID MenuCategoryId, @RequestBody MenuItem menuItem, @PathVariable UUID MenuItemId) {
        return ResponseEntity.status(200).body(menuItemService.updateMenuItem(MenuItemId, menuItem));
    }

    //delete
    @DeleteMapping("/{MenuCategoryId}/menu-item/{MenuItemId}")
    void deleteMenuItem(@PathVariable UUID MenuCategoryId, @PathVariable UUID MenuItemId) {
        menuItemService.deleteMenuItem(MenuItemId);
    }

}
