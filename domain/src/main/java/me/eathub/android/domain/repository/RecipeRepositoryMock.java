package me.eathub.android.domain.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import me.eathub.android.domain.Recipe;

public class RecipeRepositoryMock implements RecipeRepository {

    @Override public void getPopularRecipeList(PopularRecipeListCallback callback) {
        List<Recipe> recipes = new ArrayList<Recipe>();
        Recipe recipe1 = new Recipe(1);
        recipe1.setTitle("Tarta de huesitos casera");
        recipe1.setAuthorName("Natalia");
        recipe1.setCoverUrl("http://eathub.s3.amazonaws.com/images/c491b80c39abd1004e7bd8705ef8b4364461c07b.jpg");

        Recipe recipe2 = new Recipe(2);
        recipe2.setTitle("Pizza a los cuatro quesos");
        recipe2.setAuthorName("Argentina");
        recipe2.setCoverUrl("http://eathub.s3.amazonaws.com/images/pizza_cuatro_quesos.persist.jpeg");

        Recipe recipe3 = new Recipe(3);
        recipe3.setTitle("Milanesa a la Napolitana");
        recipe3.setAuthorName("Argentina");
        recipe3.setCoverUrl("http://eathub.s3.amazonaws.com/images/milanesa.persist.jpg");

        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);

        callback.onRecipeListLoaded(recipes);
    }
}
