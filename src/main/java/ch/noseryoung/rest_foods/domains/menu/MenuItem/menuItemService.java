package ch.noseryoung.rest_foods.domains.menu.MenuItem;


import ch.noseryoung.rest_foods.Exceptions.ResourceNotFoundException;
import ch.noseryoung.rest_foods.domains.menu.menuCategory.MenuCategory;
import ch.noseryoung.rest_foods.domains.menu.menuCategory.menuCategoryRepository;
import lombok.extern.log4j.Log4j2;
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
        getMenuCategory(menuCategoryId);
        return menuItemRepository.findByMenuCategoryMenuId(menuCategoryId);
    }

    public MenuItem getMenuItemById(UUID menuCategoryId, UUID menuItemId) throws ResourceNotFoundException {
        MenuItem menuItem = menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new ResourceNotFoundException("Menu-item with this Id was not found"));

        if (menuItem.getMenuCategory() == null || !menuItem.getMenuCategory().getMenuId().equals(menuCategoryId)) {
            throw new ResourceNotFoundException("Menu-item with this Id was not found in this menu-category");
        }

        return menuItem;
    }


    public MenuItem createMenuItem(UUID menuCategoryId, MenuItem menuItem) {
        if (menuItem == null) {
            throw new IllegalArgumentException("A menu item is required");
        }

        MenuCategory menuCategory = getMenuCategory(menuCategoryId);
        menuItem.setItemId(null);
        menuItem.setMenuCategory(menuCategory);
        return menuItemRepository.save(menuItem);
    }

    public MenuItem updateMenuItem(UUID menuCategoryId, UUID menuItemId, MenuItem newItem) throws ResourceNotFoundException {
        if (newItem == null) {
            throw new IllegalArgumentException("A menu item is required");
        }

        MenuItem menuItem = getMenuItemById(menuCategoryId, menuItemId);
        menuItem.setChefsChoice(newItem.isChefsChoice());
        menuItem.setVegetarian(newItem.isVegetarian());
        menuItem.setFish(newItem.isFish());
        menuItem.setMeat(newItem.isMeat());
        return menuItemRepository.save(menuItem);
    }


    public void deleteMenuItem(UUID menuCategoryId, UUID menuItemId) {
        MenuItem menuItem = getMenuItemById(menuCategoryId, menuItemId);
        menuItemRepository.delete(menuItem);
    }

    private MenuCategory getMenuCategory(UUID menuCategoryId) {
        return menuCategoryRepository.findById(menuCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException("A Menu-category with this Id was not found"));
    }
}
