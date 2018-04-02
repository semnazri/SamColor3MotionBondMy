package a3motion.com.colorbond.View;

import a3motion.com.colorbond.POJO.RewardListResponse;

public interface RewardListVIew {

    void ResultList(String response_message, RewardListResponse rewardListResponse);

    void setelseEror(String response_message);
}
