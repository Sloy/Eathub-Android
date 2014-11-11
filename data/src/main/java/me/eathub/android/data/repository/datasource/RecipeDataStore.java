package me.eathub.android.data.repository.datasource;

import java.util.List;

import me.eathub.android.data.entity.RecipeEntity;

public interface RecipeDataStore {

    List<RecipeEntity> getRecipeEntityList();
}
