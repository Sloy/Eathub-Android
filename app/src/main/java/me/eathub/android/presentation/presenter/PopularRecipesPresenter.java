package me.eathub.android.presentation.presenter;

import java.util.List;

import me.eathub.android.domain.interactor.GetPopularRecipeListUseCase;
import me.eathub.android.presentation.mapper.RecipeModelDataMapper;
import me.eathub.android.presentation.model.RecipeModel;
import me.eathub.android.presentation.view.PopularRecipesView;

public class PopularRecipesPresenter implements Presenter {

    private final PopularRecipesView viewRecipeList;
    private final GetPopularRecipeListUseCase getPopularRecipeListUseCase;
    private final RecipeModelDataMapper recipeModelDataMapper;

    public PopularRecipesPresenter(PopularRecipesView viewRecipeList, GetPopularRecipeListUseCase getPopularRecipeListUseCase, RecipeModelDataMapper recipeModelDataMapper) {
        this.viewRecipeList = viewRecipeList;
        this.getPopularRecipeListUseCase = getPopularRecipeListUseCase;
        this.recipeModelDataMapper = recipeModelDataMapper;
    }

    public void initialize() {
        this.loadRecipeList();
    }

    private void loadRecipeList() {
        this.hideViewRetry();
        this.showViewLoading();
        this.getRecipeList();
    }

    private void getRecipeList() {
        getPopularRecipeListUseCase.execute()
                .map(recipeModelDataMapper::transform)
                .subscribe(recipes -> {
                    PopularRecipesPresenter.this.showRecipesCollectionInView(recipes);
                    PopularRecipesPresenter.this.hideViewLoading();
                }, error -> {
                    PopularRecipesPresenter.this.hideViewLoading();
                    PopularRecipesPresenter.this.showErrorMessage(error);
                    PopularRecipesPresenter.this.showViewRetry();
                });
    }

    public void showViewLoading() {
        this.viewRecipeList.showLoading();
    }

    private void hideViewLoading() {
        this.viewRecipeList.hideLoading();
    }

    private void showViewRetry() {
        this.viewRecipeList.showRetry();
    }

    public void hideViewRetry() {
        this.viewRecipeList.hideRetry();
    }

    private void showErrorMessage(Throwable errorBundle) {
        viewRecipeList.showError(errorBundle.getMessage()); //TODO message factory O.o
    }

    private void showRecipesCollectionInView(List<RecipeModel> recipeModelCollection) {
        this.viewRecipeList.renderRecipeList(recipeModelCollection);
    }

}
