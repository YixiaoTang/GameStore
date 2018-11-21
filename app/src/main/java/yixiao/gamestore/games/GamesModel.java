package yixiao.gamestore.games;

import android.util.Log;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import java.util.ArrayList;
import java.util.List;


import yixiao.gamestore.common.Game;

public class GamesModel implements GamesContract.Model {

    private GamesContract.Presenter presenter;



    @Override
    public void fetchData() {
        /**Hard code to test fetch data.
         ArrayList<Game> gameList = new ArrayList<>();
         Game game = new Game();
         game.setPrice("3000");
         game.setName("The Legend of Zelda");
         game.setImage("https://cdn.images.dailystar.co.uk/dynamic/184/photos/778000/620x/5a745632e74a2_LegendofZeldaonNintendoSwitchsettomakeBIGchangeafterBreathoftheWildsuccess619697.jpg");
         gameList.add(game);
         */
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Game");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> GameList, ParseException e) {
                ArrayList<Game> gameList = new ArrayList<>();
                if (e == null) {
                    for (ParseObject object : GameList) {
                        Game game = new Game();
                        game.setGameId(object.getInt("gameId"));
                        game.setPrice(getPrice((object.getInt("price"))));
                        game.setName(object.getString("name"));
                        game.setImage(object.getString("image"));
                        gameList.add(game);
                    }
                    presenter.loadGames(gameList);
                } else {
                    Log.d("game", "Error: " + e.getMessage());
                }
            }
        });


        //presenter.loadGames(gameList);
    }

    @Override
    public void setPresenter(GamesContract.Presenter presenter) {
        this.presenter = presenter;
    }


    private String getPrice(int n){
        String price = Integer.toString(n);
        return "$"+price.substring(0,price.length()-2) + '.' + price.substring(price.length()-2);
    }
}