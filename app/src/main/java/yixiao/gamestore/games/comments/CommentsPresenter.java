package yixiao.gamestore.games.comments;

import java.util.List;

import yixiao.gamestore.common.Comment;

public class CommentsPresenter implements CommentsContract.Presenter {

    private final CommentsContract.Model model;
    private CommentsContract.View view;

    public CommentsPresenter() {
        model = new CommentsModel();
        model.setPresenter(this);
    }

    @Override
    public void loadComments(List<Comment> commentList) {
        if (view != null) {
            view.loadComments(commentList);
        }
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
        this.model.fetchData(1);
    }

    @Override
    public void onViewDetached() {
        this.view = null;
    }
}
