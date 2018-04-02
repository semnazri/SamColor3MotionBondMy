package a3motion.com.colorbond.View;

import a3motion.com.colorbond.POJO.InspirasiResponse;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface InspirasiView {

    void ResultInspirasi(String response_message, InspirasiResponse inspirasiResponse);

    void setelseEror(String response_message);
}
