package yixiao.gamestore.games;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import yixiao.gamestore.R;
import java.util.List;

import yixiao.gamestore.common.Game;
import yixiao.gamestore.common.ViewModelAdapter;
import yixiao.gamestore.mvp.MvpFragment;

public class GamesFragment extends MvpFragment<GamesContract.Presenter> implements GamesContract.View{

    private TextView emptyState;
    private ViewModelAdapter GamesAdapter;

    @Override
    public GamesContract.Presenter getPresenter() {
        return new GamesPresenter();
    }

    @Override
    public void loadGames(List<Game> GameList) {

    }

    public static GamesFragment newInstance() {
        Bundle args = new Bundle();
        GamesFragment fragment = new GamesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_games, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        emptyState = view.findViewById(R.id.empty_state);
        GamesAdapter = new ViewModelAdapter();
        recyclerView.setAdapter(GamesAdapter);

        return view;

    }


}
