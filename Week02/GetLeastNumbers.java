import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 最小的k个数
 *
 * @ClassName GetLeastNumbers
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-21 23:43
 * @Version 1.0
 **/
public class GetLeastNumbers {

    /**
     * 输入：arr = [3,2,1], k = 2
     * 输出：[1,2] 或者 [2,1]
     *
     * 输入：arr = [0,1,2,1], k = 1
     * 输出：[0]
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr == null || arr.length < k){
            return arr;
        }
        Arrays.sort(arr);
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = arr[i];
        }
        return res;
    }

    public int[] getLeastNumbers1(int[] arr, int k) {
        if(arr == null || arr.length < k){
            return arr;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int a:arr){
            heap.add(a);
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = heap.poll();
        }
        return res;
    }
}
