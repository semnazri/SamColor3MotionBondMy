package a3motion.com.colorbond.View;

import a3motion.com.colorbond.POJO.SubmitResponse;

public interface RewardReedemView {

    void ResultList(String response_message, SubmitResponse submitResponse);

    void setelseEror(String response_message);
}
