/**
 * 88. 合并两个有序数组
 * @ClassName Merge
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-08 23:50
 * @Version 1.0
 **/
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m + n - 1; i >= 0; i--){
            if(m - 1 < 0 || (n - 1 >= 0 && nums1[m - 1] < nums2[n - 1])){
                nums1[i] = nums2[n - 1];
                n--;
            }else{
                nums1[i] = nums1[m - 1];
                m--;
            }
        }
    }
}