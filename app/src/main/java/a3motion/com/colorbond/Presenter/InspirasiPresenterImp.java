package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.EventResponse;
import a3motion.com.colorbond.POJO.InspirasiResponse;
import a3motion.com.colorbond.View.EventView;
import a3motion.com.colorbond.View.InspirasiView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class InspirasiPresenterImp implements InspirasriPresenter, InspirasiInteractor.OnSuccessgetInspirasiListener {
    private InspirasiView inspirasiView;
    private InspirasiInteractor inspirasiInteractor;

    public InspirasiPresenterImp(InspirasiView inspirasiView){
        this.inspirasiView = inspirasiView;
        this.inspirasiInteractor = new InspirasiInteractorImp();
    }

    @Override
    public void getListInspirasi(String token) {
        inspirasiInteractor.getInspirasi(token,this);
    }

    @Override
    public void onDestroy() {
        inspirasiView = null;
    }


    @Override
    public void onSuccess(String response_message, InspirasiResponse inspirasiResponse) {
        if (inspirasiView != null){
            inspirasiView.ResultInspirasi(response_message,inspirasiResponse);
        }
    }

    @Override
    public void onelseError(String response_message) {
        if (inspirasiView != null){
            inspirasiView.setelseEror(response_message);
        }
    }
}
