package com.suhael.jpa.entities.cookbook;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "recipe")
public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;

    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name="recipe_tag", joinColumns = @JoinColumn(name ="tag_fk"), inverseJoinColumns = @JoinColumn(name="recipe_fk"))
    private Set<Tag> tags;

    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name="recipe_ingredient", joinColumns = @JoinColumn(name ="ingredient_fk"), inverseJoinColumns = @JoinColumn(name="recipe_fk"))
    private Set<Ingredient> ingredients;

    public Recipe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;

        if (id != recipe.id) return false;
        if (title != null ? !title.equals(recipe.title) : recipe.title != null) return false;
        if (description != null ? !description.equals(recipe.description) : recipe.description != null) return false;
        if (tags != null ? !tags.equals(recipe.tags) : recipe.tags != null) return false;
        return !(ingredients != null ? !ingredients.equals(recipe.ingredients) : recipe.ingredients != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (ingredients != null ? ingredients.hashCode() : 0);
        return result;
    }
}
