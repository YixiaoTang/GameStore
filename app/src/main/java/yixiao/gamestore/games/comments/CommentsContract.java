package yixiao.gamestore.games.comments;

import yixiao.gamestore.mvp.MvpContract;
import java.util.List;

public interface CommentsContract  {
    interface View extends MvpContract.View<Presenter> {
        void loadComments (List<Comment> commentList);
    }

    interface Presenter extends  MvpContract.Presenter<View, Model> {
        void loadComments (List<Comment> commentList);
        void fetchData(int gameId);
    }

    interface Model extends MvpContract.Model<Presenter> {
        void fetchData(int gameId);
    }
}