package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.EventResponse;
import a3motion.com.colorbond.POJO.RegisterResponse;
import a3motion.com.colorbond.View.EventJoin;
import a3motion.com.colorbond.View.EventView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class JoinEventPresenterImp implements JoinEventPresenter, JoinEventInteractor.OnSuccessJoinEventListener {
    private EventJoin eventJoin;
    private JoinEventInteractor eventInteractor;

    public JoinEventPresenterImp(EventJoin eventView){
        this.eventJoin = eventView;
        this.eventInteractor = new JoinEventInteractorImp();
    }


    @Override
    public void doJoinEvent(String token, String id_event, String status) {
        eventInteractor.doJoinEvent(token,id_event,status,this);
    }

    @Override
    public void onDestroy() {
        eventJoin = null;
    }



    @Override
    public void onSuccess(String response_message, RegisterResponse registerResponse) {
        if (eventJoin != null){
            eventJoin.ResulJoinEvent(response_message,registerResponse);
        }
    }

    @Override
    public void onelseError(String response_message) {
        if (eventJoin != null){
            eventJoin.setelseEror(response_message);
        }
    }
}
