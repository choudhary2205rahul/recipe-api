package com.recipe.api.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "recipes", indexes = {
        @Index(name = "idx_student_id", columnList = "id")
})
@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString(exclude = {"ingredients", "categories"})
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "serving")
    private int serving;

    @Column(name = "instructions")
    private String instructions;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    private Set<Ingredients> ingredients = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    private Set<Category> categories = new HashSet<>();

    public void addIngredients(Ingredients ingredient) {
        if (ingredient != null) {
            if (this.ingredients == null) {
                this.ingredients = new HashSet<>();
            }
            this.ingredients.add(ingredient);
        }
    }

    public void addCategories(Category category) {
        if (category != null) {
            if (this.categories == null) {
                this.categories = new HashSet<>();
            }
            this.categories.add(category);
        }
    }
}
