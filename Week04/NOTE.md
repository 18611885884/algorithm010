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