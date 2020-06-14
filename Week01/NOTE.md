## 五毒刷题法

1、刷题第一遍

​		-- 5分钟：思考 + 读题（最多不要超多15分钟）

​		-- 直接看解决：注意！多解法，比较解法优劣（如何 15 分钟后依旧没思路的情况下）

​		-- **背诵、默写好的解法**（这一步很重要）

2、刷题第二遍

​		-- 回忆每种写法，并默写，反复debug直到熟练，

​		-- 体会总结每种写法的优劣，并进行优化

​		-- 总结反思自己的解题思路

3、刷题第三遍

​		-- 一天后重复做题，重复第二遍

4、刷题第四遍

​		-- 一周后重复做题

5、刷题第五遍

​		-- 面试前一个月重复做之前的题



## 第一周

### 第三课 -- 数组、链表、跳表

#### 数组

- Array 

  特性：有序

- 时间复杂度

  O(1)：prepend、append、lookup（查找）

  O(n)：insert、delete（增删）

- 实战题目
  - 盛水最多的容器：https://leetcode-cn.com/problems/container-with-most-water/
    - 解题方法：双重循环（O(n^2)）、双指针（O(n)）
  - 移动零：https://leetcode-cn.com/problems/move-zeroes/
    - 解题方法：两次循环（O(n)两次遍历）、快慢指针（O(n)一次遍历）
    - 第二遍刷题：快慢指针中for循环体处理逻辑加强记忆。
  - 爬楼梯：https://leetcode.com/problems/climbing-stairs/
    - 解题遇到问题：暴力？只考虑基本情况！
  - 找最近重复子问题
    - 解题方法：斐波拉契数列 f(n) = f(n - 1) + f(n - 2)，配合缓存使用，时间复杂度O(n)
  - 三数之和：https://leetcode-cn.com/problems/3sum/
    - 两数之和：暴力双重for循环求解，O(n^2)，主要掌握双重循环指针不重复写法
    - 三数之和解法：利用 LinkedHashSet 数据结构，存储不重复结果。三重循环O(n^3)
      - Arrays.sort  O(n * logn)
      - 夹逼法 O(n^2) 可以理解成双指针，去重技巧需要加强记忆
      - 细节，最左边值大于0 一定没有符合条件结果。利用while 去除中间指针右边重复值情况。去除右边指针左边重复值情况。
  
- Java 源码分析 ArrayList
  - 核心点：System.arraycopy();
  - add：将原数组复制两段（0 ~ index, index + 1 ~ size - index），将index 赋值
  - romve:：将原数组分两段（0 ~ index + 1, index ~ size - index - 1），将 --size赋值为空

#### 链表 -- 单向链表、双向链表、环形链表

- LinkList

  LRU缓存算法：https://www.jianshu.com/p/b1ab4a170c3c

  LeetCode：https://leetcode-cn.com/problems/lru-cache

- 时间复杂度

  O(1)：prepend、append、insert、delete（增删 -- 某个位置 index）

  O(n)：lookup（查找）

- Java 源码分析 LinkList（双向链表）
  
  - 重新对index - 1 的下节点，原index位置的上节点，目标index的上下节点重新定义。
  
- 实战题目

  - 反转链表：https://leetcode.com/problems/reverse-linked-list/
    - 循环 O(n)，好理解，步骤参考代码注释
    - 递归 O(n)，代码简洁
  - 两两交换链表中的节点：https://leetcode.com/problems/swap-nodes-in-pairs
    - 一张图解决问题 O(n)![a.jpg](https://pic.leetcode-cn.com/43254846f029b4814a6c9a139e4f9f89833ac54803ea50b24feb35210631f88b-a.jpg)
    - 递归写法：没有实现后续补充
  - 环形链表：https://leetcode.com/problems/linked-list-cycle
    - 利用HashSet判断是否有重复O(n)
    - 快慢指针O(n)
  - K个一组翻转链表：https://leetcode.com/problems/reverse-nodes-in-k-group/

- LinkList 解题手法：解题思路固定熟悉怎么吧next和p指针换来换去，好干瘪的手法 哈哈哈

#### 跳表

- 使用场景：有序链表

  Redis - Skip List：https://redisbook.readthedocs.io/en/latest/internal-datastruct/skiplist.html

  https://www.zhihu.com/question/20202931

- 核心思想：升维思想 + 空间换时间

- 时间复杂度：O(logn)
- 空间复杂度：O(n)



## 第四课 -- 栈、队列、双端队列、优先队列

### 栈 Stack

- 特性：先进后出，Last in First out（LIFO）
- 时间复杂度：添加、删除皆为O(1)
- Java 源码分析 http://developer.classpath.org/doc/java/util/Stack-source.html
  - 

### 队列 Queue

- 特性：先进先出，First in First out

- 时间复杂度：添加、删除皆为O(1)
- Java源码分析 http://fuseyism.com/classpath/doc/java/util/Queue-source.html
  - 

### 双端队列 Deque

- 特性：两端都可以进出的 Queue

- 时间复杂度：添加、删除皆为O(1)

### 优先队列 Priority Queue

- 特性：和插入顺序无关，插入元素级别越高越先出队，类似vip排队，vip级别越高排队越靠前

- 时间复杂度：

  插入：O(1)

  取出：O(logn)，按照元素优先级取出

- 底层实现：heap(堆)、bst（Binary Search Tree 二叉搜索树）、treap（tree + heap）
- Java 文档 http://docs.oracle.com/javase/10/docs/api/java/util/PriorityQueue.html

### 学习方法总结

1. 查看源码
2. 查看API、以及相关接口、实现类

# 总结

1. 后面复杂数据结构和算法的解题思想：找重复，升维思想
2. Java中 stack、queue、deque 何如查询接口信息？何如使用？
3. 没有很好的看国际站 高票代码，抽出时间时间少做两道题，多看国际站高票解题思路