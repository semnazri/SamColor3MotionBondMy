package a3motion.com.colorbond.Presenter;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface DisJoinEventPresenter {
    void doDisJoinEvent(String token, String id_event);
    void onDestroy();

}
