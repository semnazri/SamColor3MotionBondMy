package a3motion.com.colorbond.View;

import a3motion.com.colorbond.POJO.ChangePassResponse;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 15/03/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface ChangePassView {
    void setOldPassError();

    void setNewPassError();

    void setNewPassInvalid();

    void setNewREPassError();

    void setValid();

    void ResultChangePass(String response_message, ChangePassResponse changePassResponse);

    void setElseError(String response_message);
}
