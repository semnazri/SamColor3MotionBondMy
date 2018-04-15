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
    public void validateCredentials(String fristname, String lastname, String company, String title, String DOB, String Gender, String email, String phone, String image, String password, String repassword, String Type, String Typeuser) {
        registerInteractor.doRegister(fristname, lastname, company, title, DOB, Gender, email,phone,image,password,repassword,Type,Typeuser,this);

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
    public void onFirstnameError() {
        if (registerView != null){
            registerView.setfristNameError();
        }
    }

    @Override
    public void onLastnameError() {
        if (registerView != null){
            registerView.setlastNameError();
        }
    }

    @Override
    public void onCompanyError() {
        if (registerView != null){
            registerView.setCompanyError();
        }
    }

    @Override
    public void onDateError() {
        if (registerView != null){
            registerView.setDOBError();
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
    public void onPhoneError() {
        if (registerView != null){
            registerView.setPhoneError();
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
