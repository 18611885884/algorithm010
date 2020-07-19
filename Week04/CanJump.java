/**
 * 55. 跳跃游戏
 * @ClassName CanJump
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-12 23:41
 * @Version 1.0
 **/
public class CanJump {
    public boolean canJump(int[] nums) {
        int end = 0;
        int maxIndex = 0;
        for(int i = 0; i < nums.length - 1; i++){
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if(end == i){
                if(end == maxIndex){
                    return false;
                }
                end = maxIndex;
            }
        }
        return true;
    }
}
