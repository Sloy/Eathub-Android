package me.eathub.android.presentation.view;

import java.util.List;

import me.eathub.android.presentation.model.RecipeModel;

public interface PopularRecipesView extends LoadDataView{

    void renderRecipeList(List<RecipeModel> recipeModelCollection);

}
