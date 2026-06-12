package ch.noseryoung.rest_foods.domains.menu.menuCategory;


import ch.noseryoung.rest_foods.Exceptions.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Log4j2
@Service
public class menuCategoryService {


    @Autowired
    menuCategoryRepository menuCategoryRepository;


    public List<MenuCategory> getAllMenuCategories() {
        return menuCategoryRepository.findAll();
    }


    public MenuCategory getMenuCategoryById(UUID menuCategoryId) throws ResourceNotFoundException {
        return menuCategoryRepository.findById(menuCategoryId).orElseThrow(() -> new ResourceNotFoundException("A Menu-category with this Id was not found"));
    }

    public MenuCategory createMenuCategory(MenuCategory menuCategory) {
        if (menuCategory == null) {
            throw new IllegalArgumentException("A menu category is required");
        }

        menuCategory.setMenuId(null);
        return menuCategoryRepository.save(menuCategory);
    }

    public MenuCategory updateMenuCategory(
            UUID menuCategoryId, MenuCategory newCategory
    ) throws ResourceNotFoundException {
        if (newCategory == null) {
            throw new IllegalArgumentException("A menu category is required");
        }

        MenuCategory menuCategory = getMenuCategoryById(menuCategoryId);
        return menuCategoryRepository.save(menuCategory);
    }


    public void deleteMenuCategory(UUID menuCategoryId) {
        MenuCategory menuCategory = getMenuCategoryById(menuCategoryId);
        menuCategoryRepository.delete(menuCategory);
    }


}
