package me.eathub.android.domain.interactor;

import java.util.List;

import me.eathub.android.domain.Recipe;
import me.eathub.android.domain.repository.RecipeRepository;
import rx.Observable;
import rx.Subscriber;

public class GetPopularRecipeListInteractorImpl implements GetPopularRecipeListInteractor {

    private RecipeRepository recipeRepository;

    public GetPopularRecipeListInteractorImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override public Observable<List<Recipe>> execute() {
        return Observable.create(subscriber -> {
            subscriber.onNext(recipeRepository.getPopularRecipeList());
            subscriber.onCompleted();
        });
    }
}
