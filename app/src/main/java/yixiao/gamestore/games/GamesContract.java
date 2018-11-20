package yixiao.gamestore.games;

import yixiao.gamestore.mvp.MvpContract;
import yixiao.gamestore.common.Game;
import java.util.List;

public interface GamesContract {
    interface View extends MvpContract.View<Presenter> {
        void loadGames (List<Game> GameList);
    }

    interface Presenter extends  MvpContract.Presenter<View, Model> {
        void loadGames (List<Game> GameList);

    }

    interface Model extends MvpContract.Model<Presenter> {
        void fetchData();
    }
}
