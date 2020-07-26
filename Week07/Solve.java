import java.util.Arrays;

/**
 * 130. 被围绕的区域
 * @ClassName Solve
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-24 00:06
 * @Version 1.0
 **/
public class Solve {
    /**
     * 示例:
     *
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     * 运行你的函数后，矩阵变为：
     *
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     *
     *
     * 解题思路：深度优先
     */
    public void solve(char[][] board) {
        if(board.length == 0){
            return;
        }
        int n = board.length;
        int m = board[0].length;
        boolean[][] bj = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j  = 0; j < m; j++){
                if(i == 0 || i == n - 1 || j == 0 || j == m - 1){
                    dfs(board, bj, i, j);
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j  = 0; j < m; j++){
                if(!bj[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, boolean[][] bj, int i, int j) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || bj[i][j]){
            return;
        }
        if(board[i][j] == 'O'){
            bj[i][j] = true;
            int[][] fx = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for(int[] f : fx){
                dfs(board, bj, i + f[0], j + f[1]);
            }
        }
    }

    /**
     * 方法二 并查集
     * 思路：将每个边上的点设为根结点
     * @param board
     */
    public void solve1(char[][] board) {
        if(board.length == 0){
            return;
        }
        int n = board.length;
        int m = board[0].length;

    }

    public class UnionFind {
        private int count = 0;
        private int[] parent;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int pf = find(p);
            int qf = find(q);
            if(pf == qf) return;
            parent[pf] = qf;
            count--;
        }
    }
}
