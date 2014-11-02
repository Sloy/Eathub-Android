package me.eathub.android.presentation.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import me.eathub.android.R;
import me.eathub.android.data.entity.mapper.RecipeEntityDataMapper;
import me.eathub.android.data.repository.RecipeDataRepository;
import me.eathub.android.data.repository.datasource.RecipeDataStoreFactory;
import me.eathub.android.domain.executor.AsyncExecutor;
import me.eathub.android.domain.executor.PostExecutor;
import me.eathub.android.domain.interactor.GetPopularRecipeListUseCase;
import me.eathub.android.domain.interactor.GetPopularRecipeListUseCaseImpl;
import me.eathub.android.domain.repository.RecipeRepository;
import me.eathub.android.presentation.UIThread;
import me.eathub.android.presentation.executor.JobExecutor;
import me.eathub.android.presentation.mapper.RecipeModelDataMapper;
import me.eathub.android.presentation.model.RecipeModel;
import me.eathub.android.presentation.presenter.PopularRecipesPresenter;
import me.eathub.android.presentation.view.PopularRecipesView;
import me.eathub.android.presentation.view.activity.PopularRecipesActivity;
import me.eathub.android.presentation.view.adapter.RecipeGridAdapter;

public class PopularRecipesFragment extends BaseFragment implements PopularRecipesView {

    @InjectView(R.id.popular_recipes_list) RecyclerView recyclerView;

    private PopularRecipesActivity activity;
    private PopularRecipesPresenter popularRecipesPresenter;
    private Picasso picasso;

    public PopularRecipesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_popular_recipes, container, false);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        picasso = Picasso.with(getActivity());
        this.popularRecipesPresenter.initialize();
    }

    @Override public void renderRecipeList(List<RecipeModel> recipeModelCollection) {
        recyclerView.setAdapter(new RecipeGridAdapter(recipeModelCollection, picasso));
    }

    @Override public void setHeaderTitle(String title) {
        activity.getSupportActionBar().setTitle(title);
    }

    @Override void initializePresenter() {
        RecipeEntityDataMapper recipeEntityDataMapper = new RecipeEntityDataMapper();
        RecipeDataStoreFactory recipeDataStoreFactory = new RecipeDataStoreFactory();
        RecipeRepository recipeRepository = RecipeDataRepository.getInstance(recipeDataStoreFactory, recipeEntityDataMapper);

        AsyncExecutor asyncExecutor = JobExecutor.getInstance();
        PostExecutor postExecutor = UIThread.getInstance();
        GetPopularRecipeListUseCase getPopularRecipeListUseCase = new GetPopularRecipeListUseCaseImpl(recipeRepository, asyncExecutor, postExecutor);

        RecipeModelDataMapper recipeModelDataMapper = new RecipeModelDataMapper();

        popularRecipesPresenter = new PopularRecipesPresenter(this, getPopularRecipeListUseCase, recipeModelDataMapper);
    }

    @Override public void showLoading() {
        //TODO
    }

    @Override public void hideLoading() {
        //TODO
    }

    @Override public void showRetry() {
        //TODO
    }

    @Override public void hideRetry() {
        //TODO
    }

    @Override public void showError(String message) {
        //TODO
    }

    @Override public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (PopularRecipesActivity) activity;
    }

    @Override public void onDetach() {
        super.onDetach();
        this.activity = null;
    }
}
