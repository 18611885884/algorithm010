/**
 * 200. 岛屿数量
 *
 * @ClassName NumIslands
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-02 23:32
 * @Version 1.0
 **/
public class NumIslands {

    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(numIslands(i, j, grid) == 1){
                    res += 1;
                }
            }
        }
        return res;
    }

    private int numIslands(int i, int j, char[][] grid) {
        if(grid[i][j] == '1'){
            grid[i][j] = '0';
            if(i + 1 < grid.length) numIslands(i + 1, j, grid);
            if(i - 1 >= 0) numIslands(i - 1, j, grid);
            if(j + 1 < grid[i].length) numIslands(i, j + 1, grid);
            if(j - 1 >= 0) numIslands(i, j - 1, grid);
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int res = new NumIslands().numIslands(new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}});
        System.out.println(res);
    }
}
