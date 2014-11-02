package me.eathub.android.data.repository;

import java.util.Collection;

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

    @Override public void getPopularRecipeList(final PopularRecipeListCallback recipeListCallback) {
        final RecipeDataStore recipeDataStore = recipeDataStoreFactory.createMemoryDataStore();
        recipeDataStore.getRecipeEntityList(new RecipeDataStore.RecipeListCallback() {
            @Override public void onRecipeListLoaded(Collection<RecipeEntity> recipeEntityCollection) {
                Collection<Recipe> recipes = RecipeDataRepository.this.recipeEntityDataMapper.transform(recipeEntityCollection);
                recipeListCallback.onRecipeListLoaded(recipes);
            }

            @Override public void onError(Exception exception) {
                recipeListCallback.onError(new RepositoryErrorBundle(exception));
            }
        });
    }
}
