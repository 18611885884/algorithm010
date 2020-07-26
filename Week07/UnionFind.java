/**
 * 并查集代码模板
 * @ClassName UnionFind
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-23 11:21
 * @Version 1.0
 **/
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
        for(int i = 0; i < n; i++){
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
