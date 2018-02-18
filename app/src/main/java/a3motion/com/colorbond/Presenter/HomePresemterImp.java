package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.HomeResponse;
import a3motion.com.colorbond.View.HomeView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 18/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class HomePresemterImp implements HomePresejter, HomeInteractor.OnSuccessgetHomeListener {

    private HomeView homeView;
    private HomeInteractor homeInteractor;

    public HomePresemterImp(HomeView homeView) {
        this.homeView = homeView;
        this.homeInteractor = new HomeInteractorImp();
    }

    @Override
    public void getHomeApi(String token) {
        homeInteractor.getHome(token, this);
    }

    @Override
    public void onDestroy() {
        homeView = null;
    }

    @Override
    public void onSuccess(String response_message, HomeResponse homeResponse) {
        if (homeView != null) {
        homeView.ResultHome(response_message, homeResponse);
        }
    }

    @Override
    public void onelseError(String response_message) {
        if (homeView != null){
            homeView.setelseEror(response_message);
        }
    }
}
