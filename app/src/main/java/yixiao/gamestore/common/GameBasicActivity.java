package yixiao.gamestore.common;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

public abstract class GameBasicActivity extends AppCompatActivity implements GameFragmentManager {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
    }


    @LayoutRes
    protected abstract int getLayout();

    @Override
    public void doFragmentTransaction(GameBasicFragment basicFragment) {
    }


}
