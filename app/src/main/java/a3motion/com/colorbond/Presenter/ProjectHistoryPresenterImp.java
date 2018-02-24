package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.ProjectHistoryResponse;
import a3motion.com.colorbond.View.ProjectHistoryView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 24/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class ProjectHistoryPresenterImp implements ProjectHistoryPresenter, ProjectHistoryInteractor.OnSuccessgetPHhistoryListener{
    private ProjectHistoryView projectHistoryView;
    private ProjectHistoryInteractor projectHistoryInteractor;

    public ProjectHistoryPresenterImp(ProjectHistoryView view){
        this.projectHistoryView = view;
        this.projectHistoryInteractor = new ProjectHistoryInteractorImp();
    }

    @Override
    public void getProjectHistory(String token) {
        projectHistoryInteractor.getProjectHIstory(token, this);
    }

    @Override
    public void onDestroy() {
        projectHistoryView = null;
    }

    @Override
    public void onSuccess(String response_message, ProjectHistoryResponse historyResponse) {
        if (projectHistoryView != null){
            projectHistoryView.ResultProjectHistory(response_message, historyResponse);
        }
    }

    @Override
    public void onelseError(String response_message) {
        if (projectHistoryView != null){
            projectHistoryView.setelseEror(response_message);
        }
    }
}
