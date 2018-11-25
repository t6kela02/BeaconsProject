package beacon.beaconsproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static Context context;

    static int userId;

    private PageAdapter pageAdapter;
    private ViewPager viewPager;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        context = getApplicationContext();

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        userId = intent.getIntExtra("user_id", -1);
        Log.d("debug", "Name: " + name + " ID: " + userId);

        pageAdapter = new PageAdapter(getSupportFragmentManager());

        viewPager = findViewById(R.id.container);
        setupViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentMeasure(), "MEASURE DATA");
        adapter.addFragment(new FragmentVisualize(), "VISUALIZE DATA");
        viewPager.setAdapter(adapter);
    }
}