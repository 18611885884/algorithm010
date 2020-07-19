## 第十二课 动态规划

- 定义：把一个复杂的问题分解为更简单的子问题

- 分治 + 最优子结构

  - 差异：最优子结构、中途可以淘汰次优解（个人理解：时间复杂度一样，分治是汇总）

  - ```java
    // F[n] = F[n - 1] + F[n - 2]
    
    a[0] = 0; a[1] = 1;
    for(int i = 2; i < len; i++){
      a[i] = a[i - 1] + a[i - 2]
    }
    ```

    

- 斐波拉契数列：O(2^n)、结合缓存使用（记忆化） --- 自底向上
  
  - 重要掌握递推（迭代），对比分治（斐波拉契） ---自上向下
- DP三部曲：
  - 子问题
  - 状态定义
  - DP方程

### 实战题目

- 不同路径：https://leetcode-cn.com/problems/unique-paths/
  - 递归分治：O(2^n) 运行超时
  - DP：自底向上，汇总解决方案，递推 O(m*n) 二维数组 空间复杂度 O(2n)
  - DP：优化使用一位数组解决，理解思想 O(n*m) 空间复杂度 O(n)

- 不同路径II：https://leetcode-cn.com/problems/unique-paths-ii/
  - DP：自底向上，汇总解决方案，递推 O(m*n) 二维数组 空间复杂度 O(2n)

- 最长公共子序列：https://leetcode-cn.com/problems/longest-common-subsequence/
  - DP：核心代码
  - 巧妙创建长度 + 1二维数组，可以初始化第一行和第一列
- 三角形最小路径和：https://leetcode-cn.com/problems/triangle/
  - DP：开辟新的二维数组记录每个节点最小值，依次向上进行汇总
- 最大子序列和：https://leetcode-cn.com/problems/maximum-subarray/
  - DP：定义全局最大变量、和上一节点最大变量进行比较

- 乘积最大子数组：https://leetcode-cn.com/problems/maximum-product-subarray
  - DP：定义当前最大值和最小值，遇到负数最小值有可能成为最大值
- 零钱兑换：https://leetcode-cn.com/problems/coin-change/description/
  - DP：从1块钱开始计算 每个值能满足的最小情况，差值只需要上一个满足情况值加1

