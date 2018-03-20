package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.ChangePassResponse;
import a3motion.com.colorbond.View.ChangePassView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 15/03/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class ChangePasswordPresenterImp implements ChangePasswordPresenter, ChangePasswordInteractor.onSuccessChangePassListener {

    private ChangePassView changePassView;
    private ChangePasswordInteractor changePasswordInteractor;

    public ChangePasswordPresenterImp(ChangePassView view) {
        this.changePassView = view;
        this.changePasswordInteractor = new ChangePasswordInteractorImp();
    }

    @Override
    public void validateCredentials(String Token, String OldPass, String newPass_1, String newPass_2) {
        changePasswordInteractor.doChangePassword(Token,OldPass,newPass_1,newPass_2,this);
    }

    @Override
    public void onDestroy() {
        changePassView = null;

    }

    @Override
    public void onSuccess(String response_message, ChangePassResponse changePassResponse) {
        if (changePassView != null) {
            changePassView.ResultChangePass(response_message, changePassResponse);
        }
    }

    @Override
    public void onOldPassError() {
        if (changePassView != null){
            changePassView.setOldPassError();
        }
    }

    @Override
    public void onNewPassError() {
        if (changePassView != null){
            changePassView.setNewPassError();
        }
    }

    @Override
    public void onNewRePassError() {
        if (changePassView != null){
            changePassView.setNewREPassError();
        }
    }

    @Override
    public void onNewRePassinvalid() {
        if (changePassView != null){
            changePassView.setNewPassInvalid();
        }
    }

    @Override
    public void onValid() {
        if (changePassView != null){
            changePassView.setValid();
        }
    }

    @Override
    public void onElseError(String response_message) {
        if (changePassView != null){
            changePassView.setElseError(response_message);
        }
    }
}
