package yixiao.gamestore.common;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;


public class GameViewPager extends ViewPager{
    public GameViewPager(Context context) {
        super(context);
    }

    public GameViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    //No swipe
    public boolean onInterceptTouchEvent(MotionEvent event) {
        //return super.onInterceptTouchEvent(event);
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //return super.onTouchEvent(event);
        return false;
    }
}

