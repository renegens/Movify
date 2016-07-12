package com.renegens.movify.topmovies;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.renegens.movify.root.AppClass;
import com.renegens.movify.R;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import org.themoviedb.models.toprated.Result;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListFragment extends Fragment implements RecyclerItemClickListener.OnItemClickListener, ListFragmentMVP.View {

    private static final String TAG = ListFragment.class.getName();

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.listFragment_rootView)
    ViewGroup rootView;

    @Inject
    ListFragmentMVP.Presenter presenter;


    private ListAdapter listAdapter;
    private List<Result> resultList = new ArrayList<>();

    public ListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((AppClass) getActivity().getApplication()).getComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, view);

        listAdapter = new ListAdapter(resultList);
        recyclerView.setAdapter(listAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext()));

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        return view;
    }

    @Override
    public void updateData(Result result) {
        System.out.println(result.title);
        resultList.add(result);
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public void showSnackbar(String msg) {
        Snackbar.make(rootView, msg, Snackbar.LENGTH_SHORT).show();

    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.rxUnsubscribe();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.loadData();

    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onItemLongClick(View view, int position) {

    }

}
