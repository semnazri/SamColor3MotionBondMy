package a3motion.com.colorbond.Presenter;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface JoinEventPresenter {
    void doJoinEvent(String token,String id_event, String status);
    void onDestroy();

}
