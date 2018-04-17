package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.RegisterResponse;
import a3motion.com.colorbond.View.EventDisjoin;
import a3motion.com.colorbond.View.EventJoin;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class DisJoinEventPresenterImp implements DisJoinEventPresenter, DIsJoinEventInteractor.OnSuccessDIsJoinEventListener {
    private EventDisjoin eventDisjoin;
    private DIsJoinEventInteractor dIsJoinEventInteractor;

    public DisJoinEventPresenterImp(EventDisjoin eventView){
        this.eventDisjoin = eventView;
        this.dIsJoinEventInteractor = new DIsJoinEventInteractorImp();
    }


    @Override
    public void doDisJoinEvent(String token, String id_event) {
        dIsJoinEventInteractor.doDisJoinEvent(token,id_event,this);
    }

    @Override
    public void onDestroy() {
        eventDisjoin = null;
    }



    @Override
    public void onSuccess(String response_message, RegisterResponse registerResponse) {
        if (eventDisjoin != null){
            eventDisjoin.ResulDIsJoinEvent(response_message,registerResponse);
        }
    }

    @Override
    public void onelseError(String response_message) {
        if (eventDisjoin != null){
            eventDisjoin.setelseEror(response_message);
        }
    }
}
