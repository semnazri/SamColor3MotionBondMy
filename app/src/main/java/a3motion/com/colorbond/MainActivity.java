package a3motion.com.colorbond;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import a3motion.com.colorbond.Fragment.FragmentEvent;
import a3motion.com.colorbond.Fragment.FragmentHelp;
import a3motion.com.colorbond.Fragment.FragmentHome;
import a3motion.com.colorbond.Fragment.FragmentMerchantPromo;
import a3motion.com.colorbond.Fragment.FragmentNotif;
import a3motion.com.colorbond.Fragment.Fragment_Inspirasi;
import a3motion.com.colorbond.Fragment.Fragment_PT_NS;
import a3motion.com.colorbond.Fragment.Fragment_VariantColor;
import a3motion.com.colorbond.Fragment.Fragment_account;
import a3motion.com.colorbond.Fragment.Point_Parent;
import a3motion.com.colorbond.Fragment.Project_HistoryParent;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;
import a3motion.com.colorbond.Utility.BottomNavigationViewHelper;
import de.hdodenhof.circleimageview.CircleImageView;
import q.rorbin.badgeview.QBadgeView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    public static ActionBarDrawerToggle toggle;
    public static DrawerLayout mDrawerLayout;
    public static TextView title_page;
    public static ImageView img_title;
    public static Toolbar mToolbar;
    public static int counterhere = 0;
    private static View v;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    private BottomNavigationView btmView;
    private FragmentTransaction ft;
    private TextView username;
    private CircleImageView imageview;
    private SharedPreferences prefsprivate;
    private String nama, image, merchant_type;
    private ImageView img_ig, img_youtube, img_web;
    private MaterialDialog mDialog;

    public static void counter(Context context, int counters) {
        counterhere = counters;
        new QBadgeView(context).bindTarget(v).setBadgeNumber(counters);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

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

        Menu navmenu = navigationView.getMenu();


        onNavigationItemSelected(navigationView.getMenu().getItem(0));
        View header = navigationView.getHeaderView(0);
        username = header.findViewById(R.id.name);
        imageview = header.findViewById(R.id.nav_photo_profile);

        View img = navigationView.getRootView();
        img_ig = img.findViewById(R.id.ig);
        img_youtube = img.findViewById(R.id.yt);
        img_web = img.findViewById(R.id.web);


        prefsprivate = getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        nama = prefsprivate.getString(BlueScoopPreferences.firstname, "Username");
        image = prefsprivate.getString(BlueScoopPreferences.lastname, "Username");
        merchant_type = prefsprivate.getString(BlueScoopPreferences.merchant_type, "Username");


        if (merchant_type.equals("1") || merchant_type.equals("2")) {
            navmenu.findItem(R.id.benefit).setVisible(false);

        }


        RequestOptions myoptions = new RequestOptions()
                .placeholder(R.drawable.ic_person_black_24dp)
                .error(R.drawable.ic_person_black_24dp);
        Glide.with(this).load("")
                .apply(myoptions).into(imageview);
        username.setText(nama + " " + image);

        img_ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.instagram.com/colorbond.id/");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.instagram.com/colorbond.id/")));
                }
            }
        });

        img_youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.youtube.com/channel/UC6ob6B0lXVeKQd1ZOYRVIaA/");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.google.android.youtube");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.youtube.com/channel/UC6ob6B0lXVeKQd1ZOYRVIaA/")));
                }
            }
        });

        img_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.colorbond.id");
                Intent web = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(web);

            }
        });


        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) btmView.getChildAt(0);

        v = bottomNavigationMenuView.getChildAt(2); // number of menu from left
        counter(this, counterhere);


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
                    case R.id.history_project:
                        fragmentManager = getSupportFragmentManager();
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.container_body, new Project_HistoryParent(), "home").addToBackStack("menu");
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
//                        //TODO : Replace with Fragment
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
//            if (merchant_type.equals("0")) {
//                startNewActivity(this, "com.waw.wawcard");
//            }else{
//                getdialogerror("This menu only for Bond Club Program");
//            }
            fragment = new FragmentMerchantPromo();
        } else if (id == R.id.variant) {
            fragment = new Fragment_VariantColor();
        } else if (id == R.id.bluescoop) {
            fragment = new Fragment_PT_NS();
        } else if (id == R.id.help) {
            fragment = new FragmentHelp();
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

    public void startNewActivity(Context context, String packageName) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        if (intent == null) {
            // Bring user to the market or let them choose an app?
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=" + packageName));
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    private void getToast() {
        Toast.makeText(this, "kepencet", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment f = fm.findFragmentById(R.id.container_body); // get the fragment that is currently loaded in placeholder
        Object tag = f.getTag();

        int backStackCount = getSupportFragmentManager().getBackStackEntryCount();

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else if (backStackCount >= 2) {
            fragmentManager.popBackStack();
            FragmentManager.BackStackEntry entry = getSupportFragmentManager().getBackStackEntryAt(
                    1);
            getSupportFragmentManager().popBackStack(entry.getId(),
                    FragmentManager.POP_BACK_STACK_INCLUSIVE);
            getSupportFragmentManager().executePendingTransactions();

            navigationView.getMenu().getItem(0).setChecked(true);
            MainActivity.img_title.setVisibility(View.VISIBLE);
            MainActivity.title_page.setVisibility(View.GONE);
            MainActivity.mToolbar.setVisibility(View.VISIBLE);

        } else if (tag.equals("home") || (tag.equals("inspirasi"))) {
            getFragmentManager().popBackStack();
        } else {
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

    private void getdialogerror(String response_message) {

        mDialog = new MaterialDialog.Builder(MainActivity.this)
                .title(R.string.app_name)
                .content(response_message)
                .positiveText("Close")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        mDialog.dismiss();

                    }
                })
                .show();
    }

}
