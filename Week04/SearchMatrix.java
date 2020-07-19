/**
 * 74. 搜索二维矩阵
 * @ClassName SearchMatrix
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-06 22:59
 * @Version 1.0
 **/
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0){
            return false;
        }
        int clos = matrix[0].length;
        int left = 0, right = row * clos - 1;
        int mid,value;
        while (left <= right){
            mid = left + (right - left) / 2;
            value = matrix[mid / clos][mid % clos];
            if(value == target){
                return true;
            }
            if(value < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }
}
