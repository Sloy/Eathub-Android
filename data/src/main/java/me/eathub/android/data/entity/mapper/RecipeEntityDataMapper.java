package me.eathub.android.data.entity.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import me.eathub.android.data.entity.RecipeEntity;
import me.eathub.android.domain.Recipe;

public class RecipeEntityDataMapper {

    public Recipe transform(RecipeEntity recipeEntity) {
        Recipe Recipe = new Recipe(recipeEntity.getRecipeId());
        Recipe.setCoverUrl(recipeEntity.getCoverUrl());
        Recipe.setTitle(recipeEntity.getTitle());
        Recipe.setAuthorName(recipeEntity.getAuthorName());
        return Recipe;
    }

    public Collection<Recipe> transform(Collection<RecipeEntity> recipeEntityCollection) {
        List<Recipe> recipeList = new ArrayList<Recipe>(recipeEntityCollection.size());
        Recipe recipe;
        for (RecipeEntity recipeEntity : recipeEntityCollection) {
            recipe = transform(recipeEntity);
            if (recipe != null) {
                recipeList.add(recipe);
            }
        }
        return recipeList;
    }
}
