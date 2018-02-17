package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.EventResponse;
import a3motion.com.colorbond.View.EventView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class EventPresenterImp implements EventPresenter, EventInteractor.OnSuccessgetEventListener {
    private EventView eventView;
    private EventInteractor eventInteractor;

    public EventPresenterImp(EventView eventView){
        this.eventView = eventView;
        this.eventInteractor = new EventInteractorImp();
    }

    @Override
    public void getListEvent(String token) {
        eventInteractor.getEvent(token,this);

    }

    @Override
    public void onDestroy() {
        eventView = null;
    }

    @Override
    public void onSuccess(String response_message, EventResponse eventResponse) {
        if (eventView != null){
            eventView.ResulEvent(response_message,eventResponse);
        }
    }

    @Override
    public void onelseError(String response_message) {
        if (eventView != null){
            eventView.setelseEror(response_message);
        }
    }
}
