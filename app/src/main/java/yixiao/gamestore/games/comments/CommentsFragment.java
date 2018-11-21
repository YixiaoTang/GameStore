package yixiao.gamestore.games.comments;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import yixiao.gamestore.R;
import yixiao.gamestore.common.Comment;
import yixiao.gamestore.common.Game;
import yixiao.gamestore.common.ViewModelAdapter;
import yixiao.gamestore.mvp.MvpFragment;

import static android.support.v7.widget.RecyclerView.SCROLL_STATE_IDLE;

public class CommentsFragment extends MvpFragment<CommentsContract.Presenter> implements CommentsContract.View{
    private TextView emptyState;
    private ViewModelAdapter CommentsAdapter;

    public static CommentsFragment newInstance(){
        Bundle args = new Bundle();
        CommentsFragment fragment = new CommentsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void loadComments(List<Comment> commentList) {
        if (commentList.size() == 0) {
            emptyState.setVisibility(View.VISIBLE);
        } else {
            emptyState.setVisibility(View.GONE);
        }
        if (commentList != null) {
            List<CommentsViewModel> models = new LinkedList<>();
            for (Comment comment : commentList) {
                models.add(new CommentsViewModel(comment, gameFragmentManager));
            }
            CommentsAdapter.addViewModels(models);
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
        ImageView image = view.findViewById(R.id.image);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        emptyState = view.findViewById(R.id.empty_state);
        CommentsAdapter = new ViewModelAdapter();
        recyclerView.setAdapter(CommentsAdapter);
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
        return view;

    }

}
