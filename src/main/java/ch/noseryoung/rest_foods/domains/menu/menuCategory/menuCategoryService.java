package ch.noseryoung.rest_foods.domains.menu.menuCategory;


import ch.noseryoung.rest_foods.Exceptions.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Log4j2
@Service
public class menuCategoryService {


@Autowired
private menuCategoryRepository menuCategoryRepository;

//done
    public List<MenuCategory> getAllMenuCategories() {
        return menuCategoryRepository.findAll();
    }


//done
    public @Nullable MenuCategory getMenuCategoryById(UUID menuId) throws ResourceNotFoundException {
        return menuCategoryRepository.findById(menuId).orElseThrow(() -> new ResourceNotFoundException("A Menu-category with this Id was not found"));
    }
//done
    public @Nullable MenuCategory createMenuCategory(MenuCategory menuCategory) {
        return menuCategoryRepository.save(menuCategory);
    }
//done
    public MenuCategory updateMenuCategory(
            @Nullable UUID menuId, MenuCategory newCategory
    ) throws ResourceNotFoundException {
        MenuCategory menuCategory = menuCategoryRepository.findById(menuId).orElseThrow(() -> new ResourceNotFoundException("A Menu-category with this Id was not found"));
        menuCategory.setChefsChoice(newCategory.getChefsChoice());
        menuCategory.setCategoryMeat(newCategory.getCategoryMeat());
        menuCategory.setCategoryFish(newCategory.getCategoryFish());
        menuCategory.setCategoryVegetarian(newCategory.getCategoryVegetarian());
        return menuCategoryRepository.save(menuCategory);
    }

    //done
    public void deleteMenuCategory(UUID menuId) {
        menuCategoryRepository.deleteById(menuId);
    }


}
