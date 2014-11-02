package me.eathub.android.data.repository.datasource;

public class RecipeDataStoreFactory {

    public RecipeDataStore createMemoryDataStore() {
        return new MemoryRecipeDataStore();
    }

}
