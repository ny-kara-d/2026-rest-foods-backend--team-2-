package ch.noseryoung.rest_foods.domains.menu.menuCategory;


import ch.noseryoung.rest_foods.domains.menu.MenuItem.MenuItem;
import ch.noseryoung.rest_foods.domains.menu.MenuItem.menuItemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Log4j2
@RestController
@RequestMapping("/menu_category")
//@Tag enpoints
public class menuCategoryController {
    private final menuCategoryRepository menuCategoryRepository;
    private final menuCategoryService menuCategoryService;
    private final menuItemService menuItemService;

    public menuCategoryController(menuCategoryRepository menuCategoryRepository, menuCategoryService menuCategoryService, menuItemService menuItemService) {
        this.menuCategoryRepository = menuCategoryRepository;
        this.menuCategoryService = menuCategoryService;
        this.menuItemService = menuItemService;
    }

    @GetMapping
    public Iterable<MenuCategory> getAll() {
        return this.menuCategoryRepository.findAll();
    }



    @PostMapping
    public MenuCategory create(@RequestBody MenuCategory menuCategory) {
        return this.menuCategoryRepository.save(menuCategory);
    }

    @PutMapping("/{id}")
    public MenuCategory update(@PathVariable UUID id, @RequestBody MenuCategory menuCategory) {
        return this.menuCategoryRepository.save(menuCategory);
    }




    @DeleteMapping
    public void delete(@RequestBody MenuCategory menuCategory) {
        this.menuCategoryRepository.delete(menuCategory);
    }







    //add MenuItem stuff because of 1:n relationship
    @GetMapping("/{MenuCategoryId}/menu-item")
    public List<MenuItem> getMenuItems(@PathVariable UUID MenuCategoryId) {
        return menuItemService.getMenuItemsByCategory(MenuCategoryId);
    }
    //.this instead? Idk

    @GetMapping("/{MenuCategoryId}/menu-item/{MenuItemId}")
    public ResponseEntity<Optional<MenuItem>> getMenuItemById(@PathVariable UUID MenuCategoryId, @PathVariable UUID MenuItemId) {
        return ResponseEntity.ok(menuItemService.getMenuItemById(MenuItemId));
    }
    //.this again instead?


    @PostMapping("/{MenuCategoryId}/menu-item")
    public ResponseEntity<MenuItem> createMenuItem(@PathVariable UUID MenuCategoryId, @RequestBody MenuItem menuItem) {
        return ResponseEntity.status(HttpStatus.CREATED).body(menuItemService.save(menuItem));
    }

    //put
    @PutMapping("/{MenuCategoryId}/menu-item/{MenuItemId}")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable UUID MenuCategoryId, @RequestBody MenuItem menuItem, @PathVariable UUID MenuItemId) {
        return ResponseEntity.ok(menuItemService.update(MenuItemId, menuItem));
    }

    //delete
    @DeleteMapping("/{MenuCategoryId}/menu-item/{MenuItemId}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable UUID MenuCategoryId, @PathVariable UUID MenuItemId) {
        menuItemService.delete(MenuItemId);
        return ResponseEntity.noContent().build();
    }

}
