package yixiao.gamestore;

import com.parse.Parse;

import android.app.Application;

import java.util.ArrayList;

import yixiao.gamestore.common.Game;
import yixiao.gamestore.common.ReadGame;


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

    }
}