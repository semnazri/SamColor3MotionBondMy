package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.ProjectHistoryResponse;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 24/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface ProjectHistoryInteractor {

    void getProjectHIstory(String token, OnSuccessgetPHhistoryListener listener);

    interface OnSuccessgetPHhistoryListener{
        void onSuccess(String response_message, ProjectHistoryResponse historyResponse);

        void onelseError(String response_message);
    }
}
