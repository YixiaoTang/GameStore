package yixiao.gamestore.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import yixiao.gamestore.common.GameBasicFragment;


public abstract class MvpFragment<P extends  MvpContract.Presenter> extends GameBasicFragment implements MvpContract.View<P> {


    protected P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = getPresenter();
        if (presenter != null) {
            presenter.onCreate();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (presenter != null) {
            presenter.onViewAttached(this);
        }
    }


    @Override
    public void onStop() {
        super.onStop();
        if (presenter != null) {
            presenter.onViewDetached();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.onDestroy();
        }
        presenter = null;
    }

    public abstract P getPresenter();
}
