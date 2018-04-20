package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.RegisterResponse;
import a3motion.com.colorbond.POJO.SubmitResponse;
import a3motion.com.colorbond.View.ApproveView;
import a3motion.com.colorbond.View.SubmitProjectView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class ApprovePresenterImp implements ApprovePresenter, ApproveInteractor.OnSuccessApproveListener {
    private ApproveView approveView;
    private ApproveInteractor approveInteractor;

    public ApprovePresenterImp(ApproveView approveView) {
        this.approveView = approveView;
        this.approveInteractor = new ApproveInteractorImp();
    }

    @Override
    public void doApprove(String token, String id_notif) {
        approveInteractor.doAPprove(token, id_notif, this);

    }

    @Override
    public void onDestroy() {
        approveView = null;
    }


    @Override
    public void onSuccess(String response_message, RegisterResponse registerResponse) {
        if (approveView != null) {
            approveView.ResulEvent(response_message, registerResponse);
        }
    }

    @Override
    public void onelseError(String response_message) {
        if (approveView != null) {
            approveView.setelseEror(response_message);

        }
    }
}
