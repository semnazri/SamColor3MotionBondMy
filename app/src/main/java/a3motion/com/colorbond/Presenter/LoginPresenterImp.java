package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.Auth;
import a3motion.com.colorbond.View.LoginView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 07/01/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class LoginPresenterImp implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImp(LoginView loginView){
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImp();

    }
    @Override
    public void validateCredentials(String email, String password, String img) {
        loginInteractor.login(email,password, img,this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onEmailError() {
        if (loginView != null){
            loginView.setEmailError();
        }
    }

    @Override
    public void onEmailInValid() {
        if (loginView != null){
            loginView.setEmailInvalid();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null){
            loginView.setPasswordError();
        }
    }

    @Override
    public void onPasswordInValid() {
        if (loginView != null){
            loginView.setPasswordInvalid();
        }
    }

    @Override
    public void onValid() {
        if (loginView != null){
            loginView.setvalid();
        }
    }

    @Override
    public void onSuccess(String response_message, Auth auth) {
        if (loginView != null){
            loginView.ResultLogin(response_message,auth);
        }
    }


    @Override
    public void onelseError(String response_message) {
        if (loginView != null){
            loginView.setelseEror(response_message);
        }
    }
}
