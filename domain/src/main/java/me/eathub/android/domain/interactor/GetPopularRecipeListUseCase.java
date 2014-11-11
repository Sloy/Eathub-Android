package me.eathub.android.domain.interactor;

import java.util.List;

import me.eathub.android.domain.Recipe;
import rx.Observable;

public interface GetPopularRecipeListUseCase extends Interactor{

    public Observable<List<Recipe>> execute();
}
