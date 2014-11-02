package me.eathub.android.data.repository.datasource;

import java.util.Collection;

import me.eathub.android.data.entity.RecipeEntity;

public interface RecipeDataStore {
    interface RecipeListCallback {
        void onRecipeListLoaded(Collection<RecipeEntity> recipeEntityCollection);

        void onError(Exception exception);
    }

    void getRecipeEntityList(RecipeListCallback recipeListCallback);
}
