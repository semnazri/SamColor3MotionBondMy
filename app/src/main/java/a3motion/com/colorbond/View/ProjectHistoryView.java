package a3motion.com.colorbond.View;


import a3motion.com.colorbond.POJO.ProjectHistoryResponse;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 21/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface ProjectHistoryView {

    void ResultProjectHistory(String response_message, ProjectHistoryResponse projectHistoryResponse);

    void setelseEror(String response_message);
}
