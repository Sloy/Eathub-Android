package me.eathub.android.domain.interactor;

import java.util.List;

import me.eathub.android.domain.Recipe;
import me.eathub.android.domain.repository.RecipeRepository;
import rx.Observable;

public class GetPopularRecipeListInteractorImpl implements GetPopularRecipeListInteractor {

    private RecipeRepository recipeRepository;

    public GetPopularRecipeListInteractorImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override public Observable<List<Recipe>> execute() {
        List<Recipe> result = recipeRepository.getPopularRecipeList();
        return Observable.just(result);
    }
}
