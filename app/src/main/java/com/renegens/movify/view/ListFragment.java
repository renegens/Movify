package com.renegens.movify.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.renegens.movify.R;
import com.renegens.movify.adapters.ListAdapter;
import com.renegens.movify.adapters.RecyclerItemClickListener;
import com.renegens.movify.helpers.DividerItemDecoration;
import com.renegens.movify.helpers.MovifyApp;
import com.renegens.movify.http.MovieApiService;
import com.renegens.movify.presenter.ListFragmentPresenter;
import com.renegens.movify.presenter.ListFragmentView;
import com.renegens.movify.repository.DatabaseRepository;

import javax.inject.Inject;
import java.util.List;

import org.themoviedb.models.toprated.Result;
import org.themoviedb.models.toprated.TopRated;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ListFragment extends Fragment implements RecyclerItemClickListener.OnItemClickListener, ListFragmentView {

    // Not yet used, delete at end
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = ListFragment.class.getName();
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @Inject
    DatabaseRepository databaseRepository;
    @Inject
    Context context;
    @Inject
    ListFragmentPresenter presenter;
    @Inject
    Realm realm;
    @Inject
    MovieApiService movieApiService;

    // Not yet used, delete at end
    private String mParam1;
    private String mParam2;
    private ListAdapter listAdapter;
    private List <Result> resultList;

    public ListFragment() {
    }

    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        ((MovifyApp) getActivity().getApplication()).getComponent().inject(this);
        // TODO: 27/04/16 fix me

        //subscription.unsubscribe();


        /*resultList.addChangeListener(new RealmChangeListener() {
            @Override
            public void onChange() {
                Toast.makeText(getActivity(), "something changed", Toast.LENGTH_SHORT).show();
                listAdapter.notifyDataSetChanged();

            }
        });*/

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, view);
        Observable<TopRated> topRatedMovies = databaseRepository.getTopRatedMovies(1);
        Observable<TopRated> topRatedMovies2 = databaseRepository.getTopRatedMovies(2);
        Observable<TopRated> topRatedMovies3 = databaseRepository.getTopRatedMovies(3);

        Observable<TopRated> merge = topRatedMovies.mergeWith(topRatedMovies2);

                merge
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TopRated>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(TopRated topRated) {
                        resultList = topRated.getResults();

                        listAdapter = new ListAdapter(resultList);
                        recyclerView.addItemDecoration(new DividerItemDecoration(getContext()));
                        recyclerView.setAdapter(listAdapter);
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    }
                });

        Observer <Result> observer = new Observer<Result>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Result result) {
                Log.i(TAG, "onNext: "+ result.title);
            }
        };

        /*Subscription subscription = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);*/


        /*Subscription subscription = observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<TopRated>() {
            @Override
            public void call(TopRated topRated) {
                resultList = topRated.getResults();

                listAdapter = new ListAdapter(resultList);
                recyclerView.addItemDecoration(new DividerItemDecoration(getContext()));
                recyclerView.setAdapter(listAdapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

                //recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(context, recyclerView, this));

                //System.out.print(list.get(0).title);
            }
        });*/



        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onResume() {
        super.onResume();
        //recyclerView.setAdapter(listAdapter);
        presenter.setView(this);
    }

    @Override
    public void onItemClick(View view, int position) {



    }

    @Override
    public void onItemLongClick(View view, int position) {

    }

    @Override
    public void showToast(String msg) {

    }
}
