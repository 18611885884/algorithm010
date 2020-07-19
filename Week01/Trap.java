import java.util.Arrays;

/**
 * 42. 接雨水
 * @ClassName Trap
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-09 00:19
 * @Version 1.0
 **/
public class Trap {

    // 按行汇总面积
    public int trap1(int[] height) {
        int sum = 0;
        int maxHeight = getMax(height);
        // 按行高循环 从高为 1 至 最高层
        for(int i = 1; i <= maxHeight; i++){
            // 当前行高汇总面积
            int eveSum = 0;
            // 左边高出现接下来才能计算面积  第一次出现变为 true
            boolean flag = false;
            for(int j = 0; j < height.length; j ++){
                // 左边高出现 右边只要有低的面积 + 1
                if(flag && height[j] < i){
                    eveSum++;
                }
                // 出现右边高 面积有效 汇总到sum总面积中
                if(height[j] >= i){
                    sum = sum + eveSum;
                    eveSum = 0;
                    flag = true;
                }
            }
        }
        return sum;
    }
    private int getMax(int[] height) {
        int max = 0;
        for(int i:height){
            max = Math.max(max, i);
        }
        return max;
    }

    /**
     * [0,1,0,2,1,0,1,3,2,1,2,1]
     */
    // 双指针
    public int trap(int[] height) {
        int sum = 0;
        // 左右下标
        int left = 1, right = height.length - 2;
        // 左右最高值
        int maxLeft = 0, maxRight = 0;
        // i = 1 因为防止left 等于 right
        for(int i = 1; i < height.length; i++){
            // 左右谁低谁移动
            if(height[left - 1] < height[right + 1]){
                // 左边出现最高
                maxLeft = Math.max(maxLeft, height[left - 1]);
                // 左边出现最高，比自己高，则加上响应面积
                if(maxLeft > height[left]){
                    sum = sum + maxLeft - height[left];
                }
                left++;
            }else {
                maxRight = Math.max(maxRight, height[right + 1]);
                if(maxRight > height[right]){
                    sum = sum + maxRight - height[right];
                }
                right--;
            }
        }
        return sum;
    }
}
