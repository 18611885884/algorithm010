## 第七课 泛型递归 | 树的递归
周末补看盗梦空间

- 递归代码模板

  ```java
  public void recur(int level, int param) { 
    // terminator 结束条件
    if (level > MAX_LEVEL) { 
      // process result 
      return; 
    }
    // process current logic 当前层级逻辑处理
    process(level, param); 
    // drill down 调用下一层级递归
    recur( level: level + 1, newParam); 
    // restore current status 重置当前状态，全局变量值回复
  }
  ```

- 思维要点
  - 找最近最简单方法，将其拆解成可重复解决的问题
  - 数学归纳思维

### 实战题目

- 爬楼梯：https://leetcode-cn.com/problems/climbing-stairs/
- 括号生成：https://leetcode-cn.com/problems/generate-parentheses/
  - 递归处理，先写出递归模板，不考虑有效括号问题。再优化代码仅保留有效括号
- 二叉树的最大深度：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
  - 优化后5行代码搞定，递归
- 翻转二叉树：https://leetcode-cn.com/problems/invert-binary-tree/description/
  - 递归思想完成即可
- 验证二叉搜索树
  - 迭代：利用栈依次比较，有不满足条件直接退出。
  - 递归：利用两个临时变量记录当前节点对于下一层节点的含义，用于比较，不满足直接退出。
- 二叉树的最小深度
  - 递归：注意层次结束条件，左右子节点都不存在才是层的结束
- 二叉树的序列化和反序列化
  - 后补充 ------------------------------

## 第八课 分治 | 回溯

### 分治

- 可以理解为更高级的递归算法，在递归模板中，调用下一级方法与重置状态代码之间加了一步汇总结果步骤

- 代码模板

  ```java
  public void recur(int level, int param) { 
    // terminator 结束条件
    if (level > MAX_LEVEL) { 
      // process result 
      return; 
    }
    // process current logic 当前层级逻辑处理
    process(level, param); 
    // drill down 调用下一层级递归
    Object o1 = recur( level: level + 1, newParam); 
    Object o2 = recur( level: level + 2, newParam); 
    Object o3 = recur( level: level + 3, newParam); 
    // process and generate the final result 汇总子结果
    result = process_result(subresult1, subresult2, subresult3, …)
    // restore current status 重置当前状态，全局变量值回复
  }
  ```

### 实战题目

- Pow(x, n)：https://leetcode-cn.com/problems/powx-n/
  - 分支基本思维方式，相同重复子问题做规划，O(logn)
- 子集：https://leetcode-cn.com/problems/subsets/
  - 递归中，改变了参数状态，在结束时需要还原状态
  - 迭代后补充-----------------------------
- 多数元素：https://leetcode-cn.com/problems/majority-element/description/
  - hash，O(n)
  - 排序返回中间位置元素，O(nlogn)
  - 分治，比较两边最多元素，两边最多元素相同则返回左边，否则判断最多返回上一层

### 回溯

- 递归的更高级算法，分步解决问题的过程中，发现答案不能解决问题，需要取消上一步甚至上几步的计算，在通过其他分步解答再次尝试寻找答案。

### 本周作业

- 二叉树的最近公共祖先：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/

  - ```java
    // left && right 在两条分支上，公共祖节点不是 p 或 q
    // root.val == p.val || root.val == q.val 公共节点是 p 或者 q 的情况
    if((left && right) || (root.val == p.val || root.val == q.val) && (left || right)){
      ans = root;
    }
    return left || right || (root.val == p.val || root.val == q.val);
    ```

  - 关键代码：判断左右是否有，左右有右有，当前为祖先。左或者右有，当前是其中一个，当前是祖先
  - O(n)

- 全排列：https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
  
  - n皇后和全排列是典型的回溯算法题，O(n!)

