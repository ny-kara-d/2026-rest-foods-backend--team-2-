package ch.noseryoung.rest_foods.domains.menu.MenuItem;


import ch.noseryoung.rest_foods.domains.menu.menuCategory.MenuCategory;
import ch.noseryoung.rest_foods.domains.menu.menuCategory.menuCategoryRepository;
import lombok.extern.log4j.Log4j2;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Log4j2
@Service
@Component
public class menuItemService {

    //Because of 1:m relationship, add stuff from menuCategory
//    private final menuItemRepository menuItemRepository;
//    private final menuCategoryRepository menuCategoryRepository;

//    public menuItemService(menuItemRepository menuItemRepository, menuCategoryRepository menuCategoryRepository) {
//        this.menuItemRepository = menuItemRepository;
//        this.menuCategoryRepository = menuCategoryRepository;
//    }


    @Autowired
    private menuItemRepository menuItemRepository;

    @Autowired
    private menuCategoryRepository menuCategoryRepository;


    public List<MenuItem> getAllMenuItems() {
        return this.menuItemRepository.findAll();
    }

    public Optional<MenuItem> getMenuItemById(UUID id) {
        return this.menuItemRepository.findById(id);
    }

    //something here query method
    public List<MenuItem> getMenuItemsByCategory(UUID menuCategoryId) {
        return menuItemRepository.findByMenuCategory_MenuId(menuCategoryId);
    }


    public MenuItem save(MenuItem menuItem) {
        return this.menuItemRepository.save(menuItem);
    }


    public @Nullable MenuItem update(UUID menuItemId, MenuItem menuItem) {
        return this.menuItemRepository.save(menuItem);
    }


    public void delete(UUID menuItemId) {
        this.menuItemRepository.deleteById(menuItemId);
    }
}
