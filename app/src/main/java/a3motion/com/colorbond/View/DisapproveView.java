package a3motion.com.colorbond.View;

import a3motion.com.colorbond.POJO.RegisterResponse;

public interface DisapproveView {
    void ResulEvent(String response_message, RegisterResponse registerResponse);

    void setelseEror(String response_message);
}
