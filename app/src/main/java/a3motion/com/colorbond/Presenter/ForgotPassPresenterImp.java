package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.ChangePassResponse;
import a3motion.com.colorbond.View.ChangePassView;
import a3motion.com.colorbond.View.ForgotPassView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 15/03/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class ForgotPassPresenterImp implements ForgotPassPresenter, ForgotPassInteractor.onSuccessForgotPassListener {

    private ForgotPassView forgotPassView;
    private ForgotPassInteractor forgotPassInteractor;

    public ForgotPassPresenterImp(ForgotPassView view) {
        this.forgotPassView = view;
        this.forgotPassInteractor = new ForgotPassInteractorImp();
    }



    @Override
    public void doForgot(String Email) {
        forgotPassInteractor.doChangePassword(Email,this);
    }

    @Override
    public void onDestroy() {
        forgotPassView = null;

    }

    @Override
    public void onSuccess(String response_message, ChangePassResponse changePassResponse) {
        if (forgotPassView != null) {
            forgotPassView.ResultForgotPass(response_message, changePassResponse);
        }
    }

    @Override
    public void onEmailError() {
        if (forgotPassView != null){
            forgotPassView.setEmailError();
        }
    }

    @Override
    public void onEmailinvalid() {
        if (forgotPassView != null){
            forgotPassView.setEmailInvalid();
        }
    }



    @Override
    public void onValid() {
        if (forgotPassView != null){
            forgotPassView.setValid();
        }
    }

    @Override
    public void onElseError(String response_message) {
        if (forgotPassView != null){
            forgotPassView.setElseError(response_message);
        }
    }
}
