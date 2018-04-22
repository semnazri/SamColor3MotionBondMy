package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.RewardListResponse;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface RewardListInteractor {

    void getSlider(String token,String type, String type_user, String type_reward, OnSuccessgetEventListener listener);

    interface OnSuccessgetEventListener {

        void onSuccess(String response_message, RewardListResponse rewardListResponse);

        void onelseError(String response_message);

    }

}
