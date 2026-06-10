package ch.noseryoung.rest_foods.domains.menu.menuCategory;


import lombok.extern.log4j.Log4j2;
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

    public List<MenuCategory> getAllMenuCategories() {
        return this.menuCategoryRepository.findAll();
    }

    public Optional<MenuCategory> getMenuCategory(UUID id) {
        return this.menuCategoryRepository.findById(id);
    }

//couple of missing methods
    public menuCategoryService save(MenuCategory menuCategory) {
        menuCategoryRepository.save(menuCategory);
        return this;
    }
//errors above and on line 46 47

    public menuCategoryService delete(MenuCategory id) {
        menuCategoryRepository.deleteById(id.getMenuId());
        return this;
    }

    public menuCategoryService update(UUID id, MenuCategory menuCategory) {
        menuCategory.setMenuId(id);
        return save(menuCategory);
    }


}
