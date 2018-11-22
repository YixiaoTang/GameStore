package yixiao.gamestore.common;

import android.os.Bundle;

public interface GameFragmentManager {
    void doFragmentTransaction(GameBasicFragment basicFragment);

    void startActivityWithBundle(Class<?> clazz, boolean isFinished, Bundle bundle);

    void showSnackBar(String message);

}
