package a3motion.com.colorbond.View;

import a3motion.com.colorbond.POJO.HomeResponse;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 18/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface HomeView {

    void ResultHome (String response_message, HomeResponse homeResponse);

    void setelseEror(String response_message);
}
