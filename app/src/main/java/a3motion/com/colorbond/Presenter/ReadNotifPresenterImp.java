package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.RegisterResponse;
import a3motion.com.colorbond.View.ApproveView;
import a3motion.com.colorbond.View.ReadNotifView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class ReadNotifPresenterImp implements ReadNotifPresenter, ReadNotifInteractor.OnSuccessReadListener {
    private ReadNotifView readNotifView;
    private ReadNotifInteractor readNotifInteractor;

    public ReadNotifPresenterImp(ReadNotifView readNotifView) {
        this.readNotifView = readNotifView;
        this.readNotifInteractor = new ReadNotifInteractorImp();
    }

    @Override
    public void doRead(String token, String id_notif) {
        readNotifInteractor.doRead(token, id_notif, this);
    }

    @Override
    public void onDestroy() {
        readNotifView = null;
    }


    @Override
    public void onSuccess(String response_message, RegisterResponse registerResponse) {
        if (readNotifView != null) {
            readNotifView.ResulRead(response_message, registerResponse);
        }
    }

    @Override
    public void onelseError(String response_message) {
        if (readNotifView != null) {
            readNotifView.setelseEror(response_message);

        }
    }
}
