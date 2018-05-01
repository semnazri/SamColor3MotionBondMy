package a3motion.com.colorbond.View;

import a3motion.com.colorbond.POJO.RegisterResponse;

public interface ReadNotifView {
    void ResulRead(String response_message, RegisterResponse registerResponse);

    void setelseEror(String response_message);
}
