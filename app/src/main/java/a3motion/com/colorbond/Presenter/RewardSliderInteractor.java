package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.RewardSliderResponse;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface RewardSliderInteractor {

    void getSlider(String token, String type, OnSuccessgetEventListener listener);

    interface OnSuccessgetEventListener {

        void onSuccess(String response_message, RewardSliderResponse rewardSliderResponse);

        void onelseError(String response_message);

    }

}
