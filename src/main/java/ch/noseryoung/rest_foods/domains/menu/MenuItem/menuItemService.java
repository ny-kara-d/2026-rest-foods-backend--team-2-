package ch.noseryoung.rest_foods.domains.menu.MenuItem;


import ch.noseryoung.rest_foods.domains.menu.menuCategory.MenuCategory;
import ch.noseryoung.rest_foods.domains.menu.menuCategory.menuCategoryRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Log4j2
@Service
public class menuItemService {

    //Because of 1:m relationship, add stuff from menuCategory
    private final menuItemRepository menuItemRepository;
    private final menuCategoryRepository menuCategoryRepository;

    public menuItemService(menuItemRepository menuItemRepository, menuCategoryRepository menuCategoryRepository) {
        this.menuItemRepository = menuItemRepository;
        this.menuCategoryRepository = menuCategoryRepository;
    }

  public List<MenuItem> getAllMenuItems() {
        return ch.noseryoung.rest_foods.domains.menu.MenuItem.menuItemRepository.findAll();
  }

  public Optional<MenuItem> getMenuItemById(UUID id) {
        return ch.noseryoung.rest_foods.domains.menu.MenuItem.menuItemRepository.findById();
  }



}
