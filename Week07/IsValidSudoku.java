import java.util.HashMap;
import java.util.Map;

/**
 * 36. 有效的数独
 * @ClassName IsValidSudoku
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-26 20:38
 * @Version 1.0
 **/
public class IsValidSudoku {
    /**
     * 方法一  hash
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        Map<String, Integer> rows = new HashMap<>();
        Map<String, Integer> cols = new HashMap<>();
        Map<String, Integer> boxs = new HashMap<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                char val = board[i][j];
                if(val != '.'){
                    String row = i + "," + board[i][j];
                    String col = j + "," + board[i][j];
                    String box = ((i / 3) * 3 + j / 3) + "," + board[i][j];
                    rows.put(row, rows.getOrDefault(row, 0) + 1);
                    cols.put(col, cols.getOrDefault(col, 0) + 1);
                    boxs.put(box, boxs.getOrDefault(box, 0) + 1);

                    if(rows.get(row) > 1 || cols.get(col) > 1 || boxs.get(box) > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 方法二，根据方法一优化
     */
    private final int L = 9;
    public boolean isValidSudoku1(char[][] board) {
        boolean[][] rows = new boolean[L][L];
        boolean[][] cols = new boolean[L][L];
        boolean[][] boxes = new boolean[L][L];

        for (int r = 0; r < L; ++r) {
            for (int c = 0; c < L; ++c) {
                if (board[r][c] != '.') {
                    int value = board[r][c] - '1';
                    int boxIndex = r / 3 * 3 + c / 3;
                    if (rows[r][value] || cols[c][value] || boxes[boxIndex][value]) {
                        return false;
                    }
                    rows[r][value] = true;
                    cols[c][value] = true;
                    boxes[boxIndex][value] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new IsValidSudoku().isValidSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}});
    }
}
