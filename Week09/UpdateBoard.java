/**
 * 529. 扫雷游戏
 * @ClassName UpdateBoard
 * @Description
 * @Author luozhengqi
 * @Date 2020-08-20 14:09
 * @Version 1.0
 **/
public class UpdateBoard {
    //定义方向
    private int[][] fx = new int[][]{{1,1},{1,-1},{1,0},{-1, 0}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;
        int p = click[0];
        int q = click[1];
        if(p >= m || q >= n){
            return board;
        }
        if(board[p][q] != 'E'){
            return board;
        }
        bfs(board, p, q);
        return board;
    }

    private void bfs(char[][] board, int p, int q) {
        if(board[p][q] == 'M'){

        }
    }
}
