package ch.noseryoung.rest_foods.domains.menu.MenuItem;

import ch.noseryoung.rest_foods.Exceptions.ResourceNotFoundException;
import ch.noseryoung.rest_foods.domains.menu.menuCategory.MenuCategory;
import ch.noseryoung.rest_foods.domains.menu.menuCategory.menuCategoryRepository;
import lombok.extern.log4j.Log4j2;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Log4j2
@Service
public class menuItemService {

    @Autowired
    private menuItemRepository menuItemRepository;

    @Autowired
    private menuCategoryRepository menuCategoryRepository;

    public List<MenuItem> getAllMenuItems(UUID menuCategoryId) {
        return menuItemRepository.findByMenuCategory_MenuId(menuCategoryId);
    }

    public @Nullable MenuItem getMenuItemById(UUID itemId) {
        return menuItemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Menu-item with this Id was not found"));
    }

    public MenuItem createMenuItem(UUID menuCategoryId, MenuItem menuItem) {
        MenuCategory category = menuCategoryRepository.findById(menuCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Menu category not found"));
        menuItem.setMenuCategory(category);
        return menuItemRepository.save(menuItem);
    }

    public MenuItem updateMenuItem(UUID menuCategoryId, UUID menuItemId, MenuItem newItem) {
        MenuItem menuItem = menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new ResourceNotFoundException("Menu-item with this Id was not found"));
        MenuCategory category = menuCategoryRepository.findById(menuCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Menu category not found"));
        menuItem.setChefsChoice(newItem.isChefsChoice());
        menuItem.setVegetarian(newItem.isVegetarian());
        menuItem.setFish(newItem.isFish());
        menuItem.setMeat(newItem.isMeat());
        menuItem.setMenuCategory(category);
        return menuItemRepository.save(menuItem);
    }

    public void deleteMenuItem(UUID menuItemId) {
        if (!menuItemRepository.existsById(menuItemId)) {
            throw new ResourceNotFoundException("Menu-item with this Id was not found");
        }
        menuItemRepository.deleteById(menuItemId);
    }
}
