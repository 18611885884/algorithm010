/**
 * 79. 单词搜索
 * @ClassName Exist
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-22 10:34
 * @Version 1.0
 **/
public class Exist {
    /**
     * board =
     * [
     *   ['A','B','C','E'],
     *   ['S','F','C','S'],
     *   ['A','D','E','E']
     * ]
     *
     * 给定 word = "ABCCED", 返回 true
     * 给定 word = "SEE", 返回 true
     * 给定 word = "ABCB", 返回 false
     *
     * 解题思路  trie 字典树， + DFS
     */
    // 标记用过的点不能再次使用
    boolean[][] boardFlag;
    // 总行数 总列数
    int rows, cols;
    // 二维网格
    char[][] board;
    // 目标字符
    char[] wordc;
    // 四个方向行进
    int[][] next = new int[][]{{0, -1},{0, 1},{-1, 0},{1, 0}};
    public boolean exist(char[][] board, String word) {
        wordc = word.toCharArray();
        this.board = board;
        rows = board.length;
        cols = board[0].length;
        boardFlag = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(bfs(0, i , j)) return true;
            }
        }
        return false;
    }

    private boolean bfs(int len, int row, int col) {
        if(row < 0 || row >= rows || col < 0 || col >= cols || boardFlag[row][col]){
            return false;
        }
        if (board[row][col] != wordc[len]) return false;
        if (len == wordc.length - 1) return true;
        boardFlag[row][col] = true;
        for(int[] ne : next){
            if(bfs(len + 1, row + ne[1], col + ne[0])){
                return true;
            }
        }
        boardFlag[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        new Exist().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB");
    }
}
