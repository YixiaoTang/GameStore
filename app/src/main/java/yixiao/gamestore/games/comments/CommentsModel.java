package yixiao.gamestore.games.comments;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


public class CommentsModel implements CommentsContract.Model{
    private CommentsContract.Presenter presenter;


    @Override
    public void fetchData(int gameId) {

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Comments");
        query.whereEqualTo("gameId", gameId);
        System.out.print(gameId);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> CommentList, ParseException e) {
                ArrayList<Comment> commentList = new ArrayList<>();
                if (e == null) {
                    for (ParseObject object : CommentList) {
                        Comment comment = new Comment();
                        comment.setGameId(object.getInt("gameId"));
                        comment.setName(object.getString("name"));
                        comment.setAvatar(object.getString("avatar"));
                        comment.setComment(object.getString("comment"));
                        commentList.add(comment);
                    }
                    presenter.loadComments(commentList);
                } else {
                    Log.d("comment", "Error: " + e.getMessage());
                }
            }
        });
        ArrayList<Comment> commentsList = new ArrayList<>();
        presenter.loadComments(commentsList);
    }

    @Override
    public void setPresenter(CommentsContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
