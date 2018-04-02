package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.InspirasiResponse;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface InspirasiInteractor {

    void getInspirasi(String token, OnSuccessgetInspirasiListener listener);

    interface OnSuccessgetInspirasiListener {

        void onSuccess(String response_message, InspirasiResponse inspirasiResponse);

        void onelseError(String response_message);

    }

}
