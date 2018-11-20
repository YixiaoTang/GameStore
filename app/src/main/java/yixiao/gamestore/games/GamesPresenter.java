package yixiao.gamestore.games;

import java.util.List;

import yixiao.gamestore.common.Game;

public class GamesPresenter implements GamesContract.Presenter {

    private final GamesContract.Model model;
    private GamesContract.View view;

    public GamesPresenter() {
        model = new GamesModel();
        model.setPresenter(this);
    }
    @Override
    public void loadGames(List<Game> GameList) {
        if (view != null) {
            view.loadGames(GameList);
        }
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onViewAttached(GamesContract.View view) {
        this.view = view;
        //this.model.fetchData();
    }

    @Override
    public void onViewDetached() {

    }
}
