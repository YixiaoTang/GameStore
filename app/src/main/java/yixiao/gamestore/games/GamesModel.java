package yixiao.gamestore.games;

public class GamesModel implements GamesContract.Model{

    private GamesContract.Presenter presenter;

    @Override
    public void fetchData() {

    }

    @Override
    public void setPresenter(GamesContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
