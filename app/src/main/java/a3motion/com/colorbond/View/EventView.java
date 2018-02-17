package a3motion.com.colorbond.View;

import a3motion.com.colorbond.POJO.EventResponse;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface EventView {

    void ResulEvent(String response_message, EventResponse eventResponse);

    void setelseEror(String response_message);
}
