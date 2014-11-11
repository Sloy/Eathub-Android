package me.eathub.android.domain.interactor;

import java.util.List;

import me.eathub.android.domain.Recipe;
import me.eathub.android.domain.executor.AsyncExecutor;
import me.eathub.android.domain.executor.PostExecutor;
import me.eathub.android.domain.repository.RecipeRepository;
import rx.Observable;

public class GetPopularRecipeListUseCaseImpl implements GetPopularRecipeListUseCase {

    private PostExecutor postExecutor;
    private RecipeRepository recipeRepository;

    public GetPopularRecipeListUseCaseImpl(RecipeRepository recipeRepository, AsyncExecutor asyncExecutor, PostExecutor postExecutor) {
        this.recipeRepository = recipeRepository;
        this.postExecutor = postExecutor;
    }
    @Override public Observable<List<Recipe>> execute() {
        List<Recipe> result = recipeRepository.getPopularRecipeList();
        return Observable.just(result);
    }


    @Override public void run() {

    }
}
