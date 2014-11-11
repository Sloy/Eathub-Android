package me.eathub.android.data.repository;

import java.util.Collection;
import java.util.List;

import me.eathub.android.data.entity.RecipeEntity;
import me.eathub.android.data.entity.mapper.RecipeEntityDataMapper;
import me.eathub.android.data.exception.RepositoryErrorBundle;
import me.eathub.android.data.repository.datasource.RecipeDataStore;
import me.eathub.android.data.repository.datasource.RecipeDataStoreFactory;
import me.eathub.android.domain.Recipe;
import me.eathub.android.domain.repository.RecipeRepository;

public class RecipeDataRepository implements RecipeRepository {

    private static RecipeDataRepository INSTANCE;

    public static RecipeRepository getInstance(RecipeDataStoreFactory recipeDataStoreFactory, RecipeEntityDataMapper recipeEntityDataMapper) {
        if (INSTANCE == null) {
            INSTANCE = new RecipeDataRepository(recipeDataStoreFactory, recipeEntityDataMapper);
        }
        return INSTANCE;
    }

    private final RecipeEntityDataMapper recipeEntityDataMapper;

    private final RecipeDataStoreFactory recipeDataStoreFactory;

    public RecipeDataRepository(RecipeDataStoreFactory recipeDataStoreFactory, RecipeEntityDataMapper recipeEntityDataMapper) {
        this.recipeEntityDataMapper = recipeEntityDataMapper;
        this.recipeDataStoreFactory = recipeDataStoreFactory;
    }

    @Override public java.util.List<Recipe> getPopularRecipeList() {
        final RecipeDataStore recipeDataStore = recipeDataStoreFactory.createMemoryDataStore();
        List<RecipeEntity> recipeEntityList = recipeDataStore.getRecipeEntityList();
        return this.recipeEntityDataMapper.transform(recipeEntityList);
    }
}
