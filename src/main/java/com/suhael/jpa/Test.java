package com.suhael.jpa;

import com.suhael.jpa.entities.cookbook.Ingredient;
import com.suhael.jpa.entities.cookbook.Recipe;
import com.suhael.jpa.entities.cookbook.Tag;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {

        Recipe recipe = new Recipe();
        recipe.setTitle("my burger");
        recipe.setDescription("its a good burger");

        Tag tag1 = new Tag();
        tag1.setTitle("halal");

        Tag tag2 = new Tag();
        tag2.setTitle("gluten");

        Set<Tag> tags = new HashSet<>();
        tags.add(tag1);
        tags.add(tag2);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("pepper");
        ingredient1.setDescription("pepper");

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("mushrrom");
        ingredient2.setDescription("mushroo");

        Set<Ingredient> ingredients = new HashSet<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);

        recipe.setTags(tags);
        recipe.setIngredients(ingredients);

        EntityManager em = PersistenceManager.getPersistenceManager().getEntityManager();
        em.getTransaction()
                .begin();
        em.persist(recipe);
        em.getTransaction()
                .commit();


        Recipe r = em.find(Recipe.class, 1);

        System.out.println("Recipe: " + r.getTitle());

        for (Tag tag : recipe.getTags()) {
            System.out.println("Tags: " + tag.getTitle());
        }

        em.close();
        PersistenceManager.getPersistenceManager().close();
    }
}
