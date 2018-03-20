package a3motion.com.colorbond.Presenter;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 15/03/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface ChangePasswordPresenter {
    void validateCredentials(String Token,String OldPass, String newPass_1, String newPass_2);
    void onDestroy();
}
