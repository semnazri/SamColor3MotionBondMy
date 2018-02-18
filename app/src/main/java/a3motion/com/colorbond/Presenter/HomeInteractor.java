package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.HomeResponse;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 18/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface HomeInteractor {

    void getHome(String token, OnSuccessgetHomeListener listener);

    interface OnSuccessgetHomeListener {

        void onSuccess(String response_message, HomeResponse  homeResponse);

        void onelseError(String response_message);

    }
}
