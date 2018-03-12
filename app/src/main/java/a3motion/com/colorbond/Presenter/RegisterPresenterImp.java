package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.RegisterResponse;
import a3motion.com.colorbond.View.RegisterView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 09/03/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class RegisterPresenterImp implements RegisterPresenter, RegisterInteractor.OnSuccessgetRegisterListener {
    private RegisterView registerView;
    private RegisterInteractor registerInteractor;

    public RegisterPresenterImp(RegisterView view) {
        this.registerView = view;
        this.registerInteractor = new RegisterInteractorImp();
    }


    @Override
    public void validateCredentials(String email, String fristname, String lastname, String Username, String address, String proffesion, String phone, String DOB, String Gender, String company, String Type, String Typeuser, String image, String password, String title,String repassword) {
        registerInteractor.doRegister(email, fristname, lastname, Username, address, proffesion, phone, DOB, Gender, company, Type, Typeuser, image, password, title, repassword,this);
    }

    @Override
    public void onDestroy() {

        registerView = null;

    }

    @Override
    public void onSuccess(String response_message, RegisterResponse registerResponse) {
        if (registerView != null) {
            registerView.ResultRegister(response_message, registerResponse);
        }
    }

    @Override
    public void onEmailError() {
        if (registerView != null){
            registerView.setEmailError();
        }
    }

    @Override
    public void onEmailInValid() {
        if (registerView != null){
            registerView.setEmailInvalid();
        }
    }

    @Override
    public void onPasswordError() {
        if (registerView != null){
            registerView.setPasswordError();
        }
    }

    @Override
    public void onPasswordInValid() {
        if (registerView != null){
            registerView.setPasswordInvalid();
        }
    }

    @Override
    public void onRePassError() {
        if (registerView != null){
            registerView.setRePassError();
        }
    }

    @Override
    public void onRePassInvalid() {
        if (registerView != null){
            registerView.setRePassInvalid();
        }
    }

    @Override
    public void onProffesionError() {
        if (registerView != null){
            registerView.setProfessionError();
        }
    }

    @Override
    public void OnUsernameError() {
        if (registerView != null){
            registerView.setNameError();
        }
    }

    @Override
    public void onValid() {
        if (registerView != null){
            registerView.setvalid();
        }
    }

    @Override
    public void onelseError(String response_message) {
        if (registerView != null){
            registerView.setelseEror(response_message);
        }
    }
}
