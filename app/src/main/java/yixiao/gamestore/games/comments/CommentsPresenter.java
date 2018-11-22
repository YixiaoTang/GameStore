package yixiao.gamestore.games.comments;

import java.util.List;

public class CommentsPresenter implements CommentsContract.Presenter {

    private final CommentsContract.Model model;
    private CommentsContract.View view;

    public CommentsPresenter() {
        model = new CommentsModel();
        model.setPresenter(this);
    }

    @Override
    public void loadComments(List<Comment> commentList) {
        if (view != null&&commentList!=null) {
            view.loadComments(commentList);
        }
    }

    @Override
    public void fetchData(int gameId) {
        this.model.fetchData(gameId);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onViewAttached(CommentsContract.View view) {
        this.view = view;

    }

    @Override
    public void onViewDetached() {
        this.view = null;
    }
}
