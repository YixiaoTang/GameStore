package yixiao.gamestore.common;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yixiao.gamestore.R;

import java.util.UUID;
public class GameBasicFragment extends Fragment{

    protected GameFragmentManager gameFragmentManager;
    private final String uuid = UUID.randomUUID().toString();

    @CallSuper
    public void onAttach(Context context) {
        super.onAttach(context);
        gameFragmentManager = (GameFragmentManager) context;
        //Context is MainActivity
        //所有的Activity 用了GameBasicActivity ->GameFragmentManager
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_basic, container, false);
    }

    public String getFragmentTag() {
        return this.getClass().getName() + uuid;
    }

}
