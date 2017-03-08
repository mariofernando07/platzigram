package co.com.nexus.platzigram.view;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import co.com.nexus.platzigram.R;
import co.com.nexus.platzigram.view.fragment.HomeFragment;
import co.com.nexus.platzigram.view.fragment.ProfileFragment;
import co.com.nexus.platzigram.view.fragment.SearchFragment;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottombar);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.home:
                                HomeFragment homeFragment = new HomeFragment();
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment)
                                        .setTransition((FragmentTransaction.TRANSIT_FRAGMENT_FADE))
                                        .addToBackStack(null).commit();
                                break;
                            case R.id.profile:
                                ProfileFragment profileFragment = new ProfileFragment();
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment)
                                        .setTransition((FragmentTransaction.TRANSIT_FRAGMENT_FADE))
                                        .addToBackStack(null).commit();
                                break;
                            case R.id.search:
                                SearchFragment searchFragment = new SearchFragment();
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, searchFragment)
                                        .setTransition((FragmentTransaction.TRANSIT_FRAGMENT_FADE))
                                        .addToBackStack(null).commit();
                                break;
                        }
                        return false;
                    }

                });
    }
}
