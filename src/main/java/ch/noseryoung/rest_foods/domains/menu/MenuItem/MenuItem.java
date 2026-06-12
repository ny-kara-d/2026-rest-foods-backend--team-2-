package ch.noseryoung.rest_foods.domains.menu.MenuItem;


import ch.noseryoung.rest_foods.domains.menu.menuCategory.MenuCategory;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "menu_item")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "item_id", nullable = false)
    @JsonProperty("id")
    private UUID itemId;

    @Column(nullable = false)
    private boolean chefsChoice;

    @Column(nullable = false)
    private boolean vegetarian;

    @Column(nullable = false)
    private boolean meat;

    @Column(nullable = false)
    private boolean fish;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "menu_category_id", nullable = false)
    private MenuCategory menuCategory;

}
