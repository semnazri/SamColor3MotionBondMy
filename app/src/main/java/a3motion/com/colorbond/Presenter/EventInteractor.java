package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.EventResponse;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface EventInteractor {

    void getEvent(String token, OnSuccessgetEventListener listener);

    interface OnSuccessgetEventListener {

        void onSuccess(String response_message, EventResponse eventResponse);

        void onelseError(String response_message);

    }

}
