package a3motion.com.colorbond;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 01/03/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Activity_Help extends AppCompatActivity {
    private ImageView img_nav;
    private TextView txt_title,faq;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_help);
        img_nav = findViewById(R.id.img_tolbar);
        txt_title = findViewById(R.id.txt_title_page);
        faq = findViewById(R.id.faq);
        txt_title.setText("FAQ");
        img_nav.setVisibility(View.GONE);

        faq.setText(Html.fromHtml("Q : How to upload document(s)?<br>\n" +
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
    }
}
