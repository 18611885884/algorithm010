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
- 生成括号：https://leetcode-cn.com/problems/generate-parentheses/
  - 递归处理，先写出递归模板，不考虑有效括号问题。再优化代码仅保留有效括号
- 二叉树的最大深度：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
  - 优化后5行代码搞定，递归

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

### 回溯

- 递归的更高级算法，分步解决问题的过程中，发现答案不能解决问题，需要取消上一步甚至上几步的计算，在通过其他分步解答再次尝试寻找答案。

### 实战题目

- 