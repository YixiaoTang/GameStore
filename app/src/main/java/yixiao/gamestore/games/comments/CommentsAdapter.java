package yixiao.gamestore.games.comments;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.saber.stickyheader.stickyView.StickHeaderRecyclerView;
import com.squareup.picasso.Picasso;
import java.util.LinkedList;
import java.util.List;
import yixiao.gamestore.R;
import yixiao.gamestore.common.Game;

public class CommentsAdapter extends StickHeaderRecyclerView<Comment, CommentHeader> {

    private List<Comment> commentList;
    private final int NUM_MODEL_BEFORE_COMMENTS = 2;
    private Game game;

    public void setGame(Game game) {
        this.game = game;
    }

    public CommentsAdapter(){
        this.commentList = new LinkedList<>();
    }

    public void setCommentList(List<Comment> commentList){
        this.commentList.clear();
        this.commentList.addAll(commentList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case CommentHeader.HEADER_TYPE_IMAGE:
                return new HeaderImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.image_layout, parent, false));
            case CommentHeader.HEADER_TYPE_COMMENT_BAR:
                return new HeaderCommentBarViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_bar, parent, false));
            default:
                return new CommentsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CommentsViewHolder && (position - NUM_MODEL_BEFORE_COMMENTS)<commentList.size()) {
            Comment comment = commentList.get(position-NUM_MODEL_BEFORE_COMMENTS);
            ((CommentsViewHolder) holder).comment.setText(comment.getComment());
            ((CommentsViewHolder) holder).name.setText(comment.getName());
            Picasso.get().load(comment.getAvatar()).into(((CommentsViewHolder) holder).avatar);
        } else if (holder instanceof HeaderCommentBarViewHolder){
            ((HeaderCommentBarViewHolder) holder).bindData();
        }else if (holder instanceof HeaderImageViewHolder){
            ((HeaderImageViewHolder) holder).bindData(game.getImage());
        }
    }

    @Override
    public void bindHeaderData(View header, int headerPosition) {
        // this method is called when your header move and you must not only bind header data in HeaderViewHolder
        //but also bind header data here.
    }

    class HeaderCommentBarViewHolder extends RecyclerView.ViewHolder {
        TextView commentBar;
        HeaderCommentBarViewHolder(View itemView) {
            super(itemView);
            commentBar = itemView.findViewById(R.id.comment_bar);
        }
        void bindData() {
        }
    }

    class HeaderImageViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        HeaderImageViewHolder(View itemView){
            super(itemView);
            image = itemView.findViewById(R.id.image_head);
        }
        void bindData(String url){
            Picasso.get().load(url).into(image);
        }
    }

    public static class CommentsViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView comment;
        ImageView avatar;

        public CommentsViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            comment = itemView.findViewById(R.id.comment);
            avatar = itemView.findViewById(R.id.avatar);
        }
    }


}
