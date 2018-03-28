package a3motion.com.colorbond.View;

import a3motion.com.colorbond.POJO.SubmitResponse;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 12/03/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface SubmitProjectView {

    void ResultSubmit(String response_message, SubmitResponse submitResponse);

    void setelseEror(String response_message);

    void setProjectNameError();

    void setProjectDateError();

    void setLocationError();

    void setquantitiyError();

    void setDeliveryNoteError();

    void setValid();
}
