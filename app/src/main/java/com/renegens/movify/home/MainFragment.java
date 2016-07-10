package com.renegens.movify.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.renegens.movify.AppClass;
import com.renegens.movify.R;
import com.renegens.movify.topmovies.ListFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainFragment extends Fragment implements MainFragmentMVP.View {

    private static final String TAG = MainFragment.class.getName();

    @BindView(R.id.main_fragment_topMovies_button)
    Button oneButton;

    @Inject
    MainFragmentMVP.Presenter presenter;

    public MainFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((AppClass) (getActivity().getApplication())).getComponent().inject(this);

    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setView(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.main_fragment_topMovies_button)
    public void topRatedMovies() {

        presenter.topRatedMoviesClicked();
    }

    @Override
    public void showListFragment() {
        ListFragment listFragment = new ListFragment();
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, listFragment)
                .commit();
    }
}
