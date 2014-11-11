package me.eathub.android.data.repository.datasource;

import android.util.SparseArray;

import java.util.ArrayList;
import java.util.List;

import me.eathub.android.data.entity.RecipeEntity;

public class MemoryRecipeDataStore implements RecipeDataStore {

    private final SparseArray<RecipeEntity> recipeEntityMemoryArray;
    private final List<RecipeEntity> recipeEntityMemoryList;

    public MemoryRecipeDataStore() {
        this.recipeEntityMemoryArray = new SparseArray<RecipeEntity>();
        recipeEntityMemoryList = new ArrayList<RecipeEntity>();
        this.fillWithData();
    }

    private void fillWithData() {
        RecipeEntity recipe1 = new RecipeEntity(1);
        recipe1.setTitle("Tarta de huesitos casera");
        recipe1.setAuthorName("Natalia");
        recipe1.setCoverUrl("http://eathub.s3.amazonaws.com/images/c491b80c39abd1004e7bd8705ef8b4364461c07b.jpg");

        RecipeEntity recipe2 = new RecipeEntity(2);
        recipe2.setTitle("Pizza a los cuatro quesos");
        recipe2.setAuthorName("Argentina");
        recipe2.setCoverUrl("http://eathub.s3.amazonaws.com/images/pizza_cuatro_quesos.persist.jpeg");

        RecipeEntity recipe3 = new RecipeEntity(3);
        recipe3.setTitle("Milanesa a la Napolitana");
        recipe3.setAuthorName("Argentina");
        recipe3.setCoverUrl("http://eathub.s3.amazonaws.com/images/milanesa.persist.jpg");

        RecipeEntity recipe4 = new RecipeEntity(4);
        recipe4.setTitle("Piruletas caseras");
        recipe4.setAuthorName("Virgi");
        recipe4.setCoverUrl("http://eathub.s3.amazonaws.com/images/pirus_0.persist.jpg");

        recipeEntityMemoryArray.put(recipe1.getRecipeId(), recipe1);
        recipeEntityMemoryArray.put(recipe2.getRecipeId(), recipe2);
        recipeEntityMemoryArray.put(recipe3.getRecipeId(), recipe3);
        recipeEntityMemoryArray.put(recipe4.getRecipeId(), recipe4);

        recipeEntityMemoryList.add(recipe1);
        recipeEntityMemoryList.add(recipe2);
        recipeEntityMemoryList.add(recipe3);
        recipeEntityMemoryList.add(recipe4);
        recipeEntityMemoryList.add(recipe1);
        recipeEntityMemoryList.add(recipe2);
        recipeEntityMemoryList.add(recipe3);
        recipeEntityMemoryList.add(recipe4);
        recipeEntityMemoryList.add(recipe1);
        recipeEntityMemoryList.add(recipe2);
        recipeEntityMemoryList.add(recipe3);
        recipeEntityMemoryList.add(recipe4);
        recipeEntityMemoryList.add(recipe1);
        recipeEntityMemoryList.add(recipe2);
        recipeEntityMemoryList.add(recipe3);
        recipeEntityMemoryList.add(recipe4);
        recipeEntityMemoryList.add(recipe1);
        recipeEntityMemoryList.add(recipe2);
        recipeEntityMemoryList.add(recipe3);
        recipeEntityMemoryList.add(recipe4);
    }


    @Override public List<RecipeEntity> getRecipeEntityList() {
        return recipeEntityMemoryList;
    }
}
