package ch.noseryoung.rest_foods.domains.menu.menuCategory;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @NotBlank
    @Column
    private String chefsChoice;

    @NotBlank
    @Column
    private String categoryVegetarian;

    @NotBlank
    @Column
    private String categoryMeat;

    @NotBlank
    @Column
    private String categoryFish;


}
