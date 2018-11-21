package yixiao.gamestore.common;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class ReadGame {
    public static ArrayList<Game>  readObject() {
        final ArrayList<Game> games= new ArrayList<>();
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Game");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> GameList, ParseException e) {
                if (e == null) {
                    for(ParseObject object : GameList){
                        Game game = new Game();
                        game.setGameId(object.getInt("gameId"));
                        game.setPrice(object.getString("price"));
                        game.setName(object.getString("name"));
                        game.setImage(object.getString("image"));
                        games.add(game);
                    }
                } else {
                    Log.d("game", "Error: " + e.getMessage());
                }
            }
        });
        return games;

    }
}
