package me.eathub.android.presentation.mapper;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;

import me.eathub.android.domain.Recipe;
import me.eathub.android.presentation.model.RecipeModel;

public class RecipeModelDataMapper {

    public RecipeModel transform(Recipe recipe) {
        if (recipe == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        RecipeModel recipeModel = new RecipeModel(recipe.getRecipeId());
        recipeModel.setCoverUrl(recipe.getCoverUrl());
        recipeModel.setTitle(recipe.getTitle());
        recipeModel.setAuthorName(recipe.getAuthorName());
        return recipeModel;
    }

    public Collection<RecipeModel> transform(Collection<Recipe> recipeCollection) {
        Collection<RecipeModel> recipeModelCollection;
        if (recipeCollection != null && !recipeCollection.isEmpty()) {
            recipeModelCollection = new ArrayDeque<RecipeModel>(recipeCollection.size());
            for (Recipe recipe : recipeCollection) {
                recipeModelCollection.add(transform(recipe));
            }
        } else {
            recipeModelCollection = Collections.emptyList();
        }
        return recipeModelCollection;
    }
}
