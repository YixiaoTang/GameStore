package yixiao.gamestore.games.comments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import yixiao.gamestore.R;
import yixiao.gamestore.common.Game;
import yixiao.gamestore.mvp.MvpFragment;

public class CommentsFragment extends MvpFragment<CommentsContract.Presenter> implements CommentsContract.View{
    private static final String GAME = "game";
    //private ViewModelAdapter CommentsAdapter;
    private CommentsAdapter adapter;
    private Game game;
    private ArrayList<Comment> commentList;
    private boolean hasCommentHead;

    public static CommentsFragment newInstance(Game game){
        Bundle args = new Bundle();
        args.putSerializable(GAME,game);
        CommentsFragment fragment = new CommentsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void setCommentList(ArrayList<Comment> commentList){
        this.commentList = commentList;
    }


    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void loadComments(List<Comment> commentList) {
        if (commentList.size()== 0 && !hasCommentHead) {
            CommentHeader ImageHeader = new CommentHeader(CommentHeader.HEADER_TYPE_IMAGE,R.layout.image_layout);
            ArrayList<Comment> list = new ArrayList<>();
            adapter.setGame(game);
            adapter.setCommentList(list);
            adapter.setHeaderAndData(list,ImageHeader);
            CommentHeader header = new CommentHeader(CommentHeader.HEADER_TYPE_COMMENT_BAR,R.layout.comment_bar);
            adapter.setCommentList(commentList);
            adapter.setHeaderAndData(commentList,header);
            hasCommentHead = true;
        }
        else {
            adapter.setCommentList(commentList);
            adapter.setHeaderAndData(commentList,null);
        }
    }

    @Override
    public CommentsContract.Presenter getPresenter() {
        return new CommentsPresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        game = (Game)getArguments().getSerializable(GAME);
        View view = inflater.inflate(R.layout.fragment_comments, container, false);
        TextView textView = view.findViewById(R.id.comment_title_bar);
        textView.setText(game.getName());
        RecyclerView recyclerView = view.findViewById(R.id.recycler_comment_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new CommentsAdapter();
        recyclerView.setAdapter(adapter);
        hasCommentHead = false;
        return view;

    }


}
