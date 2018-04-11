package a3motion.com.colorbond.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import a3motion.com.colorbond.MainActivity;
import a3motion.com.colorbond.MainActivity_owner;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 10/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class FragmentHelp extends Fragment {
    private View view;
    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    String userid;
    private SharedPreferences prefsprivate;
    private ImageView img_nav;
    private TextView txt_title,txt_fac;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.fragment_help,container,false);

        img_nav = view.findViewById(R.id.img_tolbar);
        txt_title = view.findViewById(R.id.txt_title_page);
        txt_fac = view.findViewById(R.id.faq);
        txt_title.setText("FAQ");

        prefsprivate = getActivity().getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        userid = prefsprivate.getString(BlueScoopPreferences.mem_type, "1");

        if (userid.equals("1")) {
            MainActivity.mToolbar.setVisibility(View.GONE);
            MainActivity.title_page.setText("FAQ");
            MainActivity.img_title.setVisibility(View.GONE);
            MainActivity.title_page.setVisibility(View.VISIBLE);

        } else {
            MainActivity_owner.mToolbar.setVisibility(View.GONE);
            MainActivity_owner.title_page.setText("FAQ");
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

        txt_fac.setText(Html.fromHtml("Q : How to upload document(s)?<br>\n" +
                "A : Click (icon), then fill the fields and documents required.<br><br>\n" +
                "\n" +
                "Q : If I have uploaded document(s), will I receive notification whether said document(s) has passed all\n" +
                "requirements needed?<br>\n" +
                "A : Yes<br><br>\n" +
                "\n" +
                "Q : How is the point counting mechanism?<br>\n" +
                "A : Please open “Bond…Program” menu to learn more details about point counting mechanism.<br><br>\n" +
                "\n" +
                "Q : How to redeem point(s) I have earned?<br>\n" +
                "A : Please enter the Reward menu and choose your prize in accordance to your current point, you will\n" +
                "later receive notification wheteher the reward is available and you redeem has been accepted.<br><br>\n" +
                "\n" +
                "Q : Can I log in using the same email and password (account) on BondPartner menu and BondContractor\n" +
                "menu?<br>\n" +
                "A : No, one account can only be used for one menu. Please contact Colorbond for more information.<br><br>\n" +
                "\n" +
                "Q : How do I know the status of my submitted project(s)?<br>\n" +
                "A : In your home page you will know the status of submitted project(s), and you will also receive\n" +
                "notification email if your submitted document(s) is approved."));
        return view;
    }
}
