package a3motion.com.colorbond.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.text.Html;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import a3motion.com.colorbond.MainActivity;
import a3motion.com.colorbond.MainActivity_owner;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;

public class FragmentMerchantPromo extends Fragment{

    private View view;
    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    String userid;
    private SharedPreferences prefsprivate;
    private ImageView img_nav;
    private TextView txt_title,txt_about;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_merchant_promo,container,false);

        img_nav = view.findViewById(R.id.img_tolbar);
        txt_title = view.findViewById(R.id.txt_title_page);
        txt_about = view.findViewById(R.id.txt_about);
        txt_title.setText("PT NS BLUESCOPE INDONESIA");

        prefsprivate = getActivity().getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        userid = prefsprivate.getString(BlueScoopPreferences.mem_type, "1");

        if (userid.equals("1")) {
            MainActivity.mToolbar.setVisibility(View.GONE);
            MainActivity.title_page.setText("MERCHANT PROMO");
            MainActivity.img_title.setVisibility(View.GONE);
            MainActivity.title_page.setVisibility(View.VISIBLE);

        } else {
            MainActivity_owner.mToolbar.setVisibility(View.GONE);
            MainActivity_owner.title_page.setText("MERCHANT PROMO");
            MainActivity_owner.img_title.setVisibility(View.VISIBLE);
            MainActivity_owner.title_page.setVisibility(View.GONE);
        }
        img_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userid.equals("1")) {
                    if (MainActivity.mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                        MainActivity.mDrawerLayout.closeDrawer(GravityCompat.START);
                    } else {
                        MainActivity.mDrawerLayout.openDrawer(GravityCompat.START);
                    }

                } else {
                    if (MainActivity_owner.mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                        MainActivity_owner.mDrawerLayout.closeDrawer(GravityCompat.START);
                    } else {
                        MainActivity_owner.mDrawerLayout.openDrawer(GravityCompat.START);
                    }

                }
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            txt_about.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
        }

        txt_about.setText(Html.fromHtml("WAWcard Amazing Membership is a privilege access facility for members provided by PT NS BlueScope Indonesia to the members in the form of shopping discount at some merchants, point and reward, free movie tickets, birthday treat with a variety of attractive surprises, a convenience in the reservation of affordable star hotels, the provision of affordable vacation packages, and so on.<br><br>Note:\n" +
                "The username and password for BondClub can be used to log in on WAWcard."));
        return view;
    }
}
