package yixiao.gamestore.games.comments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import yixiao.gamestore.R;
import yixiao.gamestore.common.Game;
import yixiao.gamestore.mvp.MvpFragment;

public class CommentsFragment extends MvpFragment<CommentsContract.Presenter> implements CommentsContract.View{
    private static final String GAME = "game";
    private TextView emptyState;
    //private ViewModelAdapter CommentsAdapter;
    private CommentsAdapter adapter;
    private Game game;

    public static CommentsFragment newInstance(Game game){
        Bundle args = new Bundle();
        args.putSerializable(GAME,game);
        CommentsFragment fragment = new CommentsFragment();
        fragment.setArguments(args);
        return fragment;
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
        game = (Game)getArguments().getSerializable(GAME);
        if (commentList.size() == 0) {
            emptyState.setVisibility(View.VISIBLE);
        } else {
            emptyState.setVisibility(View.GONE);
        }
        if (commentList!= null) {
            CommentHeader ImageHeader = new CommentHeader(CommentHeader.HEADER_TYPE_IMAGE,R.layout.image_layout);
            ArrayList<Comment> list = new ArrayList<>();
            adapter.setGame(game);
            adapter.setCommentList(list);
            adapter.setHeaderAndData(list,ImageHeader);

            CommentHeader header = new CommentHeader(CommentHeader.HEADER_TYPE_COMMENT_BAR,R.layout.comment_bar);
            adapter.setCommentList(commentList);
            adapter.setHeaderAndData(commentList,header);


            /**
            List<CommentsViewModel> models = new LinkedList<>();
            for (Comment comment : commentList) {
                models.add(new CommentsViewModel(comment, gameFragmentManager));
            }
            CommentsAdapter.addViewModels(models);
             */
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
        View view = inflater.inflate(R.layout.fragment_comments, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_comment_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        emptyState = view.findViewById(R.id.empty_state);
        adapter = new CommentsAdapter();
        recyclerView.setAdapter(adapter);
        /**
         ImageView image = view.findViewById(R.id.image);
         recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == SCROLL_STATE_IDLE) {
                    image.setVisibility(View.VISIBLE);
                } else{
                    image.setVisibility(View.GONE);
                }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

            }
        });
         */
        return view;

    }

}
