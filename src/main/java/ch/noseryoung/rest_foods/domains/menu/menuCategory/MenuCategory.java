package ch.noseryoung.rest_foods.domains.menu.menuCategory;


import ch.noseryoung.rest_foods.domains.menu.MenuItem.MenuItem;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "menu_category")
public class MenuCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "menu_id", nullable = false)
    @JsonProperty("id")
    private UUID menuId;

    @JsonManagedReference
    @OneToMany(mappedBy = "menuCategory", cascade = CascadeType.ALL)
    private List<MenuItem> menuItems;
}
