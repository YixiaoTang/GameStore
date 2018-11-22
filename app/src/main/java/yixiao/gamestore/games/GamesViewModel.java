package yixiao.gamestore.games;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import yixiao.gamestore.R;
import yixiao.gamestore.common.BaseViewModel;
import yixiao.gamestore.common.Game;
import yixiao.gamestore.common.GameFragmentManager;
import yixiao.gamestore.games.comments.CommentsFragment;


public class GamesViewModel extends BaseViewModel<GamesViewModel.GamesViewHolder> {
    private Game game;
    private GameFragmentManager fragmentManager;

    public GamesViewModel(Game game, GameFragmentManager gameFragmentManager) {
        super(R.layout.game_item);
        this.game = game;
        this.fragmentManager = gameFragmentManager;
    }

    @Override
    public GamesViewHolder createItemViewHolder(View view) {
        return new GamesViewHolder(view);
    }

    @Override
    public void bindViewHolder(GamesViewHolder holder) {

        holder.gameName.setText(game.getName());
        holder.price.setText(game.getPrice());
        Picasso.get().load(game.getImage()).into(holder.image);
        holder.itemView.setOnClickListener(v -> {
            fragmentManager.doFragmentTransaction(CommentsFragment.newInstance(game));
        });
    }


    public static class GamesViewHolder extends RecyclerView.ViewHolder {

        TextView gameName;
        TextView price;
        ImageView image;

        public GamesViewHolder(View itemView) {
            super(itemView);
            gameName = itemView.findViewById(R.id.game_name);
            price = itemView.findViewById(R.id.price);
            image = itemView.findViewById(R.id.image);
        }
    }

}
