## 第4周 第9课 深度优先搜索 & 广度优先搜索

### 深度优先

- 深度优先 -- 非递归 -- 栈

  ```java
  public void depthFirstSearch(TreeNode treeNode){
      if(treeNode == null){
          return;
      }
      Stack<TreeNode> stack = new Stack<>();
      stack.add(treeNode);
      while (!stack.isEmpty()) {
          TreeNode cur = stack.pop();
          // 处理节点信息
          if(cur.right != null){
              stack.add(cur.right);
          }
          if(cur.left != null){
              stack.add(cur.left);
          }
      }
  }
  ```

- 深度优先 -- 递归

  ```java
  public void depthFirstSearch(TreeNode treeNode){
      if(treeNode == null){
          return;
      }
      // 处理节点信息
      for(TreeNode ch:treeNode.chs){
          depthFirstSearch(ch);
      }
  }
  ```

  

### 广度优先

- 广度优先 -- 非递归 -- 队列

  ```java
  public void broadFirstSearch(TreeNode treeNode){
      if(treeNode == null){
          return;
      }
      LinkedList<TreeNode> queue = new LinkedList<>();
      queue.add(treeNode);
      while (!queue.isEmpty()) {
          TreeNode cur = queue.removeFirst();
          for(TreeNode ch:cur.chs){
              queue.add(ch);
          }
      }
  }
  ```



### 实战题目

- 二叉树的层序遍历：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description
  - 广度优先 关键代码每次弹出数量为队列之前长度
- 在每个树行中找最大值：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description
  - 广度优先，多了一次比较
- 岛屿数量：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description
  - 双重for循环，遇到1则结果加1，并将与他关联的1都置0



## 第十课 贪心算法

- 贪心算法：在当下做出最优选择
  - 作为辅助算法，结果可以接受小的偏差
  - 贪心使用场景：对条件有所要求，举例： 硬币问题20 10 5 1 到 36，10 9 1 到 18
- 回溯：可以回退
- 动态规划：最优判断 + 可以回退

### 实战题目

- 柠檬水找零：https://leetcode-cn.com/problems/lemonade-change/description/
- 买卖股票的最佳时机 II：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/



## 第十一课 二分查找

- 前提
  - 目标函数的单调性（递增或者递减）
  - 存在上下界
  - 能够通过索引访问

- 代码模板

  ```
  public void binarySearch(int[] nums, int target){
  		if(nums.length == 0){
  				return;
  		}
  		int sta = 0, end = nums.length - 1;
  		while(sta <= end){
  				// 避免数组越界
  				int mid = sta + (end - sta) / 2;
  				if(nums[mid] == target){
  						// break mid
  				}else if(nums[mid] < target){
  						sta = mid + 1;
  				}else{
  						end = mid - 1;
  				}
  		}
  }
  ```

  

### 实战题目

- x的平方根：https://leetcode-cn.com/problems/sqrtx/
- 有效的完全平方数：https://leetcode-cn.com/problems/valid-perfect-square/

## 课后作业

- 单词接龙：https://leetcode-cn.com/problems/word-ladder/description/
- 岛屿数量：https://leetcode-cn.com/problems/number-of-islands/

- 搜索旋转排序数组：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/

- 搜索二维矩阵：https://leetcode-cn.com/problems/search-a-2d-matrix/
- 寻找旋转排序数组中的最小值：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/

