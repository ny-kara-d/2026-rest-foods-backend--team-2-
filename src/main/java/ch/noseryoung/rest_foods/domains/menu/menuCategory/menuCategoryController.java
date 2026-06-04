package ch.noseryoung.rest_foods.domains.menu.menuCategory;


import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping
//@Tag enpoints
public class menuCategoryController {
    private final menuCategoryRepository menuCategoryRepository;
    private final menuCategoryService menuCategoryService;

    public menuCategoryController(menuCategoryRepository menuCategoryRepository, menuCategoryService menuCategoryService) {
        this.menuCategoryRepository = menuCategoryRepository;
        this.menuCategoryService = menuCategoryService;
    }

    @GetMapping()
    public Iterable<MenuCategory> getAll() {
        return this.menuCategoryRepository.findAll();
    }

    @GetMapping
    public Iterable<MenuCategory> getAllByOrderByNameAsc() {
        return this.menuCategoryRepository.findAll();
    }

    @PostMapping
    public MenuCategory create(@RequestBody MenuCategory menuCategory) {
        return this.menuCategoryRepository.save(menuCategory);
    }

    @PutMapping
    public MenuCategory update(@RequestBody MenuCategory menuCategory) {
        return this.menuCategoryRepository.save(menuCategory);
    }




    @DeleteMapping
    public void delete(@RequestBody MenuCategory menuCategory) {
        this.menuCategoryRepository.delete(menuCategory);
    }



}
