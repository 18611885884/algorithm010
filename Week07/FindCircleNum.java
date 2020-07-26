/**
 * 547. 朋友圈
 * @ClassName FindCircleNum
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-23 13:58
 * @Version 1.0
 **/
public class FindCircleNum {
    /**
     * 类似岛屿问题
     * 方法一 并查集
     */
    public int findCircleNum(int[][] M) {
        if(M.length == 0) return 0;
        int n = M.length;
        UnionFind unionFind = new UnionFind(n);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(M[i][j] == 1){
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.count;
    }

    /**
     * 方法二  dfs
     */
    public int findCircleNum1(int[][] M) {
        if(M.length == 0){
            return 0;
        }
        int n = M.length;
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && M[i][j] == 1){
                    res += 1;
                    dfs(M, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] m, int i, int j) {
        if(i < 0 || j < 0 || i >= m.length || j > m[i].length || i == j || m[i][j] == 0){
            return;
        }
        m[i][j] = 0;
        for(int i1 = 0; i1 < m.length; i++){
            if(m[i1][j] == 1){
                dfs(m, i1, j);
            }
        }
        for(int j1 = 0; j1 < m[i].length; j++){
            if(m[i][j1] == 1){
                dfs(m, i, j1);
            }
        }
    }

    public class UnionFind {
        // 以下注释结合 朋友圈 一题思考
        // 圈子个数
        private int count = 0;
        // 结点个数（人的数量）
        private int[] parent;

        // 初始化圈子
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for(int i = 0; i <= n; i++){
                parent[i] = i;
            }
        }

        // 查找当前结点的根节点
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
