package me.eathub.android.domain.repository;

import java.util.Collection;
import java.util.List;

import me.eathub.android.domain.Recipe;
import me.eathub.android.domain.exception.ErrorBundle;

public interface RecipeRepository {

    List<Recipe> getPopularRecipeList();
}
