package ch.noseryoung.rest_foods.domains.menu.MenuItem;


import ch.noseryoung.rest_foods.Exceptions.ResourceNotFoundException;
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



    @Autowired
    private menuItemRepository menuItemRepository;

    @Autowired
    private menuCategoryRepository menuCategoryRepository;


  public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
  }

  public @Nullable MenuItem getMenuItemById(UUID item_id) throws ResourceNotFoundException {
        return menuItemRepository.findById(item_id).orElseThrow(() -> new ResourceNotFoundException("Menu-category with this Id was not found"));
  }



    public void delete(UUID menuItemId) {
        this.menuItemRepository.deleteById(menuItemId);
    }


    public MenuItem createMenuItem(@Nullable MenuItem menuItem) {
      return menuItemRepository.save(menuItem);
    }

    public MenuItem updateMenuItem(UUID menuItemId, MenuItem newItem) throws ResourceNotFoundException {
      MenuItem menuItem = menuItemRepository.findById(menuItemId)
              .orElseThrow(()-> new ResourceNotFoundException("Menu-item with this Id was not found"));
      menuItem.setChefsChoice(newItem.isChefsChoice());
      menuItem.setVegetarian(newItem.isVegetarian());
      menuItem.setFish(newItem.isFish());
      menuItem.setMeat(newItem.isMeat());
      return menuItemRepository.save(menuItem);
    }


    public void deleteMenuItem(UUID menuItemId) {
      menuItemRepository.deleteById(menuItemId);
    }
}
