package com.renegens.movify.ui.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.renegens.movify.MovifyApp;
import com.renegens.movify.R;
import com.renegens.movify.adapters.DividerItemDecoration;
import com.renegens.movify.adapters.ListAdapter;
import com.renegens.movify.adapters.RecyclerItemClickListener;
import com.renegens.movify.http.MovieApiService;
import com.renegens.movify.repository.DatabaseRepository;
import com.renegens.movify.ui.presenter.ListFragmentMVP;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import org.themoviedb.models.toprated.Result;
import org.themoviedb.models.toprated.TopRated;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class ListFragment extends Fragment implements RecyclerItemClickListener.OnItemClickListener, ListFragmentMVP.View {

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
    ListFragmentMVP.Presenter presenter;
    @Inject
    Realm realm;
    @Inject
    MovieApiService movieApiService;

    private ListAdapter listAdapter;
    private List<Result> resultList = new ArrayList<>();

    public ListFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

        listAdapter = new ListAdapter(resultList);
        recyclerView.setAdapter(listAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext()));

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //DO ALL THIS SOMEWHERE ELSE
        Observable<TopRated> topRatedMovies = databaseRepository.getTopRatedMovies(1);
        Observable<TopRated> topRatedMovies2 = databaseRepository.getTopRatedMovies(2);
        Observable<TopRated> topRatedMovies3 = databaseRepository.getTopRatedMovies(3);

        Observable<TopRated> merged = topRatedMovies.concatWith(topRatedMovies2).concatWith(topRatedMovies3);

        Observable<Result> resultObservable = merged.flatMap(new Func1<TopRated, Observable<Result>>() {
            @Override
            public Observable<Result> call(TopRated topRated) {
                return Observable.from(topRated.results);
            }
        });

        Observer<Result> observerResults = new Observer<Result>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Result result) {
                System.out.println(result.title);
                resultList.add(result);
                listAdapter.notifyDataSetChanged();
            }
        };

        //DO ALL THIS ON AN ACTIVITY
        resultObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observerResults);

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
