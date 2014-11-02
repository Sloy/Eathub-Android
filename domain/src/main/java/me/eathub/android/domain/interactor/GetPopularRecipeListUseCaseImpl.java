package me.eathub.android.domain.interactor;

import java.util.Collection;

import me.eathub.android.domain.Recipe;
import me.eathub.android.domain.exception.ErrorBundle;
import me.eathub.android.domain.executor.AsyncExecutor;
import me.eathub.android.domain.executor.PostExecutor;
import me.eathub.android.domain.repository.RecipeRepository;
import me.eathub.android.domain.repository.RecipeRepository.PopularRecipeListCallback;

public class GetPopularRecipeListUseCaseImpl implements GetPopularRecipeListUseCase {

    private Callback callback;
    private AsyncExecutor asyncExecutor;
    private PostExecutor postExecutor;
    private RecipeRepository recipeRepository;

    public GetPopularRecipeListUseCaseImpl(RecipeRepository recipeRepository, AsyncExecutor asyncExecutor, PostExecutor postExecutor) {
        this.recipeRepository = recipeRepository;
        this.asyncExecutor = asyncExecutor;
        this.postExecutor = postExecutor;
    }
    @Override public void execute(Callback callback) {
        this.callback = callback;
        this.asyncExecutor.execute(this);
    }


    @Override public void run() {
        recipeRepository.getPopularRecipeList(repositoryCallback);

    }

    private PopularRecipeListCallback repositoryCallback = new PopularRecipeListCallback() {
        @Override public void onRecipeListLoaded(Collection<Recipe> recipeCollection) {
            notifyGetPopularRecipeListSuccessful(recipeCollection);
        }

        @Override public void onError(ErrorBundle errorBundle) {
            notifyError(errorBundle);
        }
    };

    private void notifyGetPopularRecipeListSuccessful(final Collection<Recipe> recipeCollection) {
        this.postExecutor.post(new Runnable() {
            @Override public void run() {
                callback.onRecipeListLoaded(recipeCollection);
            }
        });
    }

    private void notifyError(final ErrorBundle errorBundle) {
        this.postExecutor.post(new Runnable() {
            @Override public void run() {
                callback.onError(errorBundle);
            }
        });
    }
}
