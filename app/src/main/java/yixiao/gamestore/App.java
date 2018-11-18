package yixiao.gamestore;

import com.parse.Parse;
import com.parse.ParseObject;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import yixiao.gamestore.Common.Game;
import yixiao.gamestore.Common.ReadGame;


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.back4app_app_id))
                // if defined
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build()
        );


        ArrayList<Game> games = ReadGame.readObject();
        System.out.print(games);
    }
}