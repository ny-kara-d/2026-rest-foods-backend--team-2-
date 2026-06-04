package ch.noseryoung.rest_foods.domains.menu.menuCategory;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Log4j2
@Service
public class menuCategoryService {

    private final menuCategoryRepository menuCategoryRepository;

    public menuCategoryService(menuCategoryRepository menuCategoryRepository) {
        this.menuCategoryRepository = menuCategoryRepository;
    }


    public List<MenuCategory> getAllMenuCategories() {
        return this.menuCategoryRepository.findAll();
    }

    public Optional<MenuCategory> getMenuCategory(UUID id) {
        return this.menuCategoryRepository.findById(id);
    }




}
