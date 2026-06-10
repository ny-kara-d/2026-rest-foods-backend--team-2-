package ch.noseryoung.rest_foods.domains.menu.MenuItem;


import ch.noseryoung.rest_foods.domains.menu.menuCategory.MenuCategory;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    @Column
    private String chefsChoice1;

    @NotBlank
    @Column
    private String chefsChoice2;

    @NotBlank
    @Column
    private String vegetarian1;

    @NotBlank
    @Column
    private String vegetarian2;

    @NotBlank
    @Column
    private String meat1;

    @NotBlank
    @Column
    private String meat2;

    @NotBlank
    @Column
    private String fish1;

    @NotBlank
    @Column
    private String fish2;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "menu_category_id", nullable = false)
    private MenuCategory menuCategory;

}
