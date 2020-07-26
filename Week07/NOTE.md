## 第13课 字典树 && 并查集

### 字典树 Trie

- 字典树数据结构
  - 又称单词查找树。用于统计和排序大量的字符串（不仅限于字符串），经常被搜索引擎用于文本词频统计
  - 优点：最大减少无谓的字符串比较，查找效率比哈希表高；
- 字典树的核心思想
  - 空间换时间
  - 利用字符串公共前缀来降低查询时间的开销以达到高效的目的
- 字典树的基本性质
  - 节点不存储完整单词
  - 从根结点到某一结点，路径上经过的字符连起来，为该结点对应的字符串
  - 每个结点的所有子结点路径代表的字符都不相同
- 查询效率为单词长度

### 实战题目

- 实现 Trie (前缀树)：

  - 代码模板 直接背住就行

    ```java
    public class Trie {
    
        private Trie[] tries;
        private boolean isEnd;
    
        /** Initialize your data structure here. */
        public Trie() {
            tries = new Trie[26];
        }
    
        public Trie get(char ch){
            return tries[ch - 'a'];
        }
    
        public void put(char ch, Trie trie){
            tries[ch - 'a'] = trie;
        }
    
        public boolean isEnd() {
            return isEnd;
        }
    
        /** Inserts a word into the trie. */
        public void insert(String word) {
            if(word == null || word.length() == 0) return;
            Trie trie = this;
            for(char ch : word.toCharArray()){
                if(trie.get(ch) == null){
                    Trie trieNext = new Trie();
                    trie.put(ch, trieNext);
                    trie = trieNext;
                }else{
                    trie = trie.get(ch);
                }
            }
            trie.isEnd = true;
        }
    
        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie trie = searchPrefix(word);
            return trie != null && trie.isEnd;
        }
    
        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie trie = searchPrefix(prefix);
            return trie != null;
        }
    
        private Trie searchPrefix(String word) {
            Trie trie = this;
            for(char ch : word.toCharArray()){
                trie = trie.get(ch);
                if(trie == null){
                    return null;
                }
            }
            return trie;
        }
    }
    ```

- 单词搜索：https://leetcode-cn.com/problems/word-search/

  - 解题思路：dfs 深度优先，标记走过的点，四个方向行走代码优化

- 单词搜索II：https://leetcode-cn.com/problems/word-search-ii

  - 解题思路：引用Trie字典树结果，将单词表存入到字典树中 + 回溯

  - 时间复杂度：O(m * n * 4^k)  原因：默认初始化树的时间复杂度在遍历二维数组进行递归比较时间复杂度之下，所以可以理解成像忽略系数一样。m n 分别是二维数组长度。----------------------

  - 理解二 时间复杂度为 O(m * n * 4^k) 和 O(words.length * 最长单词长度)  两者中较小的一个

    ```java
    class Tire{
    		// 省略trie树代码
    		int[][] fx = new int[][]{{0, -1},{0, 1},{-1, 0},{1, 0}};
        public List<String> findWords(char[][] board, String[] words) {
            if(words.length == 0 || board.length == 0){
                return new ArrayList<>();
            }
            // 初始化 trie树
            Trie trie = new Trie();
            for(String word : words){
                trie.insert(word);
            }
            Set<String> res = new HashSet<>();
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    dfs(res, board, i, j, trie, "");
                }
            }
            return new ArrayList<>(res);
        }
    
        private void dfs(Set<String> res, char[][] board, int i, int j, Trie trie, String str) {
            if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '@'){
                return;
            }
            str += board[i][j];
            if(!trie.startsWith(str)){
                return;
            }
            if(trie.search(str)){
                res.add(str);
            }
            char ans = board[i][j];
            board[i][j] = '@';
            for(int[] f : fx){
                dfs(res, board, i + f[0], j + f[1], trie, str);
            }
            board[i][j] = ans;
        }
    }
    ```

### 并查集

- 适用场景
  - 组团、配对问题（岛屿）

- 基本操作

  - makeSet(s)：建立一个新的并查集，其中包含s个单元素集合
  - unionSet(x, y)：把元素 x 和 元素 y 所在的集合合并，要求x 和 y所在的集合不相交，如果相交则不合并
  - find(x)：找到元素 x 所在集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将他们各自代表比较一下就可以了

- 代码模板

  

  ```java
  class UnionFind { 
  	private int count = 0; 
  	private int[] parent; 
  	public UnionFind(int n) { 
  		count = n; 
  		parent = new int[n]; 
  		for (int i = 0; i < n; i++) { 
  			parent[i] = i;
  		}
  	} 
  	public int find(int p) { 
  		while (p != parent[p]) { 
  			parent[p] = parent[parent[p]]; 
  			p = parent[p]; 
  		}
  		return p; 
  	}
  	public void union(int p, int q) { 
  		int rootP = find(p); 
  		int rootQ = find(q); 
  		if (rootP == rootQ) return; 
  		parent[rootP] = rootQ; 
  		count--;
  	}
  }
  ```

  

- 初始化 自己 指向 自己

- 查询 合并

- 路径压缩，减少查询时间复杂度

### 实战题目

难点：如何构建并查集，和集的合并条件

- 朋友圈：https://leetcode-cn.com/problems/friend-circles
  - 解题思路：并查集实现，
- 被围绕的区域：https://leetcode-cn.com/problems/surrounded-regions/
  - 解题思路：dfs就可以， 并查集想不出来

## 第14课 高级搜索

- 剪枝
  - 类似于回溯，把不存在结果的分支去掉，不做后续处理
- 双向BFS
  - 早头部和尾部双向使用BFS，类似双向队列
  - 之前做过的题 
- 启发式搜索（A*， BFS 中队列（栈）的使用，换成优先队列）
  - 启发式函数： h(n)，它用来评价哪些结点最有希望的是一个我们要找的结 点，h(n) 会返回一个非负实数,也可以认为是从结点n的目标结点路径的估 计成本。

### 实战题目

- 剪枝- 解数独：https://leetcode-cn.com/problems/sudoku-solver/
  - 解题思路：回溯、剪枝
- 双向BFS- 单词接龙：https://leetcode-cn.com/problems/word-ladder/
  - 解题思路：双向BFS
- A*- 二进制矩阵中的最短路径：https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/
  - 解题思路：启发式搜索，优先选择当前认为最合适路径

## 第15课 AVL和红黑树

### AVL树

- 平衡因子：Balance Factor（平 是它的左子树的高度减去它的右子树的高度（有时相反）。 balance factor = {-1, 0, 1}
- 通过旋转操作来进行平衡（四种）
- ![image-20200726225613850](/Users/luozhengqi/Library/Application Support/typora-user-images/image-20200726225613850.png)

- 旋转操作：（从上执下）

  - 左旋：子树形态：右右子树 —> 左旋

  - 右旋：子树形态：左左子树 —> 右旋

  - 左右旋：子树形态：左右子树 —> 左右旋  （左节点拉到左下位置，右到之前的左节点位置，整体右旋）

    ![image-20200726230056427](/Users/luozhengqi/Library/Application Support/typora-user-images/image-20200726230056427.png)

  - 右左旋：子树形态：右左子树 —> 右左旋

    ![image-20200726230112879](/Users/luozhengqi/Library/Application Support/typora-user-images/image-20200726230112879.png)

- 带有左右子树的旋转

  ![image-20200726230152460](/Users/luozhengqi/Library/Application Support/typora-user-images/image-20200726230152460.png)

- 不足：结点需要存储额外信息、且调整次数频繁

### 红黑树

红黑树是一种近似平衡的二叉搜索树（Binary Search Tree），它能够确保任何一 个结点的左右子树的高度差小于两倍。

- 不能有相邻接的两个红色结点
- 从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点。
- 从根到叶子的最长的可能路径不多于最短的可能路径的两倍长。



### 红黑树 与 AVL树的对比

- AVL树比红黑树提供更快的查找，因为它们具有更严格的平衡。（查询多、不频繁的插入删除使用 AVL树）
- 红黑树比AVL树提供更快的插入和移除操作，因为相对宽松的平衡使得较少的旋转。
- AVL树存储每个节点的平衡因子或高度，因此每个节点需要存储一个整数，而红黑树每个节点只需要1位信息。
- 红黑树用于大多数语言库，如map, multimap, multisetin c++，而AVL树用于需要更快检索的数据库。

