package a3motion.com.colorbond;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import a3motion.com.colorbond.Fragment.FragmentEvent;
import a3motion.com.colorbond.Fragment.FragmentHome;
import a3motion.com.colorbond.Fragment.FragmentNotif;
import a3motion.com.colorbond.Fragment.Fragment_Inspirasi;
import a3motion.com.colorbond.Fragment.Fragment_Submit;
import a3motion.com.colorbond.Fragment.Fragment_account;
import a3motion.com.colorbond.Fragment.Fragment_bondPartMerchant_benefit;
import a3motion.com.colorbond.Fragment.Point_Parent;
import a3motion.com.colorbond.Fragment.Project_HistoryParent;
import a3motion.com.colorbond.Utility.BottomNavigationViewHelper;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 26/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class MainActivity_owner extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static ActionBarDrawerToggle toggle;
    public static DrawerLayout mDrawerLayout;
    public static TextView title_page;
    public static ImageView img_title;
    public Toolbar mToolbar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    private BottomNavigationView btmView;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_owner);

        Showtoolbar();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        btmView = (BottomNavigationView) findViewById(R.id.navigation);
        title_page = (TextView) findViewById(R.id.txt_title_page);
        img_title = (ImageView) findViewById(R.id.img_tolbar);
        BottomNavigationViewHelper.disableShiftMode(btmView);
        toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle.syncState();

        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(R.drawable.ic_burger2);
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        mDrawerLayout.setDrawerListener(toggle);
        mDrawerLayout.setScrimColor(getResources().getColor(android.R.color.transparent));
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
        onNavigationItemSelected(navigationView.getMenu().getItem(0));

        btmView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.action_reward:
                        fragmentManager = getSupportFragmentManager();
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.container_body, new Point_Parent(), "home").addToBackStack("menu");
                        ft.commit();
                        break;
                    case R.id.submit:
                        fragmentManager = getSupportFragmentManager();
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.container_body, new Fragment_Submit(), "home").addToBackStack("menu");
                        ft.commit();
                        break;
                    case R.id.action_notification:
                        fragmentManager = getSupportFragmentManager();
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.container_body, new FragmentNotif(), "home").addToBackStack("menu");
                        ft.commit();
                        break;
                    case R.id.inspiration:
                        fragmentManager = getSupportFragmentManager();
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.container_body, new Fragment_Inspirasi(), "home").addToBackStack("menu");
                        ft.commit();
                        //TODO : Replace with Fragment
                        break;
                }

                return true;
            }
        });


    }

    public void Showtoolbar() {

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("");

        setSupportActionBar(mToolbar);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;


        if (id == R.id.home) {
            fragment = new FragmentHome();
        } else if (id == R.id.account) {
            fragment = new Fragment_account();
        } else if (id == R.id.event) {
            fragment = new FragmentEvent();
        } else if (id == R.id.benefit) {
            fragment = new Fragment_bondPartMerchant_benefit();
        } else if (id == R.id.variant) {
            getToast();
        } else if (id == R.id.bluescoop) {
            getToast();
        } else if (id == R.id.help) {
            getToast();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        if (fragment != null) {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment, "home").addToBackStack("menu");
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle("");
        }


        return true;
    }

    private void getToast() {
        Toast.makeText(this, "kepencet", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {

        int backStackCount = getSupportFragmentManager().getBackStackEntryCount();

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Log.d("ada disini ya", "drower close");
        } else if (backStackCount >= 2) {
            fragmentManager.popBackStack();
            FragmentManager.BackStackEntry entry = getSupportFragmentManager().getBackStackEntryAt(
                    1);
            getSupportFragmentManager().popBackStack(entry.getId(),
                    FragmentManager.POP_BACK_STACK_INCLUSIVE);
            getSupportFragmentManager().executePendingTransactions();

            navigationView.getMenu().getItem(0).setChecked(true);
            MainActivity_owner.img_title.setVisibility(View.VISIBLE);
            MainActivity_owner.title_page.setVisibility(View.GONE);

        } else
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setMessage("Do you want to close this application?")
                    .setPositiveButton("Yes",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int wich) {
                                    finish();

                                }
                            }).setNegativeButton("No", null).show();
    }
}
