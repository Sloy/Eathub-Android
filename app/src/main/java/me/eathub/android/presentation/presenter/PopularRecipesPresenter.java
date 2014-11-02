package me.eathub.android.presentation.presenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import me.eathub.android.domain.Recipe;
import me.eathub.android.domain.exception.ErrorBundle;
import me.eathub.android.domain.interactor.GetPopularRecipeListUseCase;
import me.eathub.android.presentation.mapper.RecipeModelDataMapper;
import me.eathub.android.presentation.model.RecipeModel;
import me.eathub.android.presentation.view.PopularRecipesView;

public class PopularRecipesPresenter implements Presenter{

    private final PopularRecipesView viewRecipeList;
    private final GetPopularRecipeListUseCase getPopularRecipeListUseCase;
    private final RecipeModelDataMapper recipeModelDataMapper;

    public PopularRecipesPresenter(PopularRecipesView viewRecipeList, GetPopularRecipeListUseCase getPopularRecipeListUseCase, RecipeModelDataMapper recipeModelDataMapper) {
        this.viewRecipeList = viewRecipeList;
        this.getPopularRecipeListUseCase = getPopularRecipeListUseCase;
        this.recipeModelDataMapper = recipeModelDataMapper;
    }

    public void initialize() {
        this.setTitle();
        this.loadRecipeList();
    }

    private void setTitle() {
        this.viewRecipeList.setHeaderTitle("Popular Recipes");
    }

    private void loadRecipeList() {
        this.hideViewRetry();
        this.showViewLoading();
        this.getRecipeList();
    }

    private void getRecipeList() {
        getPopularRecipeListUseCase.execute(recipeListCallback);
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

    private void showErrorMessage(ErrorBundle errorBundle) {
        viewRecipeList.showError(errorBundle.getErrorMessage()); //TODO message factory O.o
    }

    private void showRecipesCollectionInView(Collection<Recipe> recipesCollection) {
        List<RecipeModel> recipeModelCollection = new ArrayList<RecipeModel>(this.recipeModelDataMapper.transform(recipesCollection));
        this.viewRecipeList.renderRecipeList(recipeModelCollection);
    }

    private final GetPopularRecipeListUseCase.Callback recipeListCallback = new GetPopularRecipeListUseCase.Callback() {
        @Override public void onRecipeListLoaded(Collection<Recipe> recipeCollection) {
            PopularRecipesPresenter.this.showRecipesCollectionInView(recipeCollection);
            PopularRecipesPresenter.this.hideViewLoading();
        }

        @Override public void onError(ErrorBundle errorBundle) {
            PopularRecipesPresenter.this.hideViewLoading();
            PopularRecipesPresenter.this.showErrorMessage(errorBundle);
            PopularRecipesPresenter.this.showViewRetry();
        }
    };

}
