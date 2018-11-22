package yixiao.gamestore.games.comments;
import java.util.ArrayList;

public class CommentsModel implements CommentsContract.Model{
    private CommentsContract.Presenter presenter;


    @Override
    public void fetchData(int gameId) {
        ArrayList<Comment> commentsList = new ArrayList<>();
        Comment comment = new Comment();
        comment.setAvatar("https://cf.ltkcdn.net/socialnetworking/images/std/168796-281x281-girl-swear-icon.png");
        comment.setComment("This game is lots of fun and feels like fire emblem. Lots to do and more strategy then you'd expect. Only issue I have is that the pricing structure for orbs and the RNG of summons don't make sense. Feels like I can't support the game financially even if I wanted to because I know I'd likely get nothing from any summoning pools I did and even the most expensive orb amount would only let you do a few summoning pools. They are generous with free orbs though.");
        comment.setName("Nathan Wihnan");
        for(int i=0;i<8;i++)
            commentsList.add(comment);
        presenter.loadComments(commentsList);
    }

    @Override
    public void setPresenter(CommentsContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
