package yixiao.gamestore;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import yixiao.gamestore.common.ContainerFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private BottomNavigationView bottomBar;
    private GameFragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = findViewById(R.id.viewpager);
        adapter = new GameFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(GameFragmentPagerAdapter.FRAGMENT_NUMBER);

        bottomBar = findViewById(R.id.bottom_navigation);
        bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                viewPager.setCurrentItem(ContainerFragment.getPositionById(item.getItemId()));
                return true;
            }
        });


        //ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
