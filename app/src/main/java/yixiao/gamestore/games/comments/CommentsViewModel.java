package yixiao.gamestore.games.comments;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import yixiao.gamestore.R;
import yixiao.gamestore.common.BaseViewModel;
import yixiao.gamestore.common.GameFragmentManager;

public class CommentsViewModel extends BaseViewModel<CommentsViewModel.CommentsViewHolder> {

    private Comment comment;
    private GameFragmentManager fragmentManager;

    public CommentsViewModel(Comment comment, GameFragmentManager gameFragmentManager) {
        super(R.layout.comment_item);
        this.comment = comment;
        this.fragmentManager = gameFragmentManager;
    }

    @Override
    public CommentsViewHolder createItemViewHolder(View view) {
        return new CommentsViewHolder(view);
    }

    @Override
    public void bindViewHolder(CommentsViewHolder holder) {
        holder.name.setText(comment.getName());
        holder.comment.setText(comment.getComment());
        Picasso.get().load(comment.getAvatar()).into(holder.avatar);
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
