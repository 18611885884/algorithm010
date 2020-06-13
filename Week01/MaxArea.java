/**
 * 盛最多水的容器
 *
 * @ClassName MaxArea
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-14 01:15
 * @Version 1.0
 **/
public class MaxArea {

    /**
     * 方法一  双重for循环
     */
    public int maxArea(int[] height) {
        if(height.length < 2){
            return 0;
        }
        int maxAr = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                maxAr = Math.max(maxAr, area);
            }

        }
        return maxAr;
    }

    /**
     * 方法二 双指针
     * [1,8,6,2,5,4,8,3,7]
     */
    public int maxArea1(int[] height) {
        if(height.length < 2){
            return 0;
        }
        int maxAr = 0;
        for (int i = 0, j = height.length -1; i < j;) {
            int area = (j - i) * Math.min(height[i], height[j]);
            maxAr = Math.max(maxAr, area);
            if (height[i] < height[j]){
                i++;
            }else{
                j--;
            }

        }
        return maxAr;
    }
}
