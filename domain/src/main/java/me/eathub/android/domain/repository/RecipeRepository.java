package me.eathub.android.domain.repository;

import java.util.Collection;

import me.eathub.android.domain.Recipe;
import me.eathub.android.domain.exception.ErrorBundle;

public interface RecipeRepository {

    interface PopularRecipeListCallback{
        void onRecipeListLoaded(Collection<Recipe> recipeCollection);

        void onError(ErrorBundle errorBundle);
    }

    void getPopularRecipeList(PopularRecipeListCallback callback);
}
