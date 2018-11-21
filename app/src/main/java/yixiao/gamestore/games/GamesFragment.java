package yixiao.gamestore.games;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import yixiao.gamestore.R;
import yixiao.gamestore.common.Game;
import yixiao.gamestore.common.ViewModelAdapter;
import yixiao.gamestore.mvp.MvpFragment;

public class GamesFragment extends MvpFragment<GamesContract.Presenter> implements GamesContract.View{

    private TextView emptyState;
    private ViewModelAdapter GamesAdapter;

    public static GamesFragment newInstance() {
        Bundle args = new Bundle();
        GamesFragment fragment = new GamesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public GamesContract.Presenter getPresenter() {
        return new GamesPresenter();
    }



    @Override
    public void loadGames(List<Game> gameList) {
        if (gameList.size() == 0) {
            emptyState.setVisibility(View.VISIBLE);
        } else {
            emptyState.setVisibility(View.GONE);
        }
        if (gameList != null) {
            List<GamesViewModel> models = new LinkedList<>();
            for (Game game : gameList) {
                models.add(new GamesViewModel(game, gameFragmentManager));
            }
            GamesAdapter.addViewModels(models);
        }
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
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
