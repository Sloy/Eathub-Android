package me.eathub.android.domain.interactor;

import java.util.Collection;

import me.eathub.android.domain.Recipe;
import me.eathub.android.domain.exception.ErrorBundle;

public interface GetPopularRecipeListUseCase extends Interactor{

    interface Callback {
        void onRecipeListLoaded(Collection<Recipe> recipeCollection);
        void onError(ErrorBundle errorBundle);
    }

    public void execute(Callback callback);
}
