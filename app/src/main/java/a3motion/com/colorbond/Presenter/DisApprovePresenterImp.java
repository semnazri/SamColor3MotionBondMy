package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.RegisterResponse;
import a3motion.com.colorbond.View.ApproveView;
import a3motion.com.colorbond.View.DisapproveView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class DisApprovePresenterImp implements DisApprovePresenter, DisApproveInteractor.OnSuccessDisApproveListener {
    private DisapproveView disapproveView;
    private DisApproveInteractor disApproveInteractor;

    public DisApprovePresenterImp(DisapproveView disapproveView) {
        this.disapproveView = disapproveView;
        this.disApproveInteractor = new DisApproveInteractorImp();
    }

    @Override
    public void doDisApprove(String token, String id_notif) {
        disApproveInteractor.doDisAPprove(token, id_notif, this);

    }

    @Override
    public void onDestroy() {
        disapproveView = null;
    }


    @Override
    public void onSuccess(String response_message, RegisterResponse registerResponse) {
        if (disapproveView != null) {
            disapproveView.ResulEvent(response_message, registerResponse);
        }
    }

    @Override
    public void onelseError(String response_message) {
        if (disapproveView != null) {
            disapproveView.setelseEror(response_message);

        }
    }
}
