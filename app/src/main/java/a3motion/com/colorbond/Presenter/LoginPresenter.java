package a3motion.com.colorbond.Presenter;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 07/01/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface LoginPresenter {

    void validateCredentials(String email, String password, String img);
    void onDestroy();
}
