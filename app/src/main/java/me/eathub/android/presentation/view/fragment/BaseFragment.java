package me.eathub.android.presentation.view.fragment;

import android.app.Fragment;
import android.os.Bundle;

public abstract class BaseFragment extends Fragment {


    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializePresenter();
    }

    abstract void initializePresenter();

}
