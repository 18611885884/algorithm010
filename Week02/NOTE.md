## 第二周 第5课 哈希表|映射|集合

- 理解：也叫离散表，根据关键码值（key - value）而直接进行访问的数据结构。通过把关键码值映射到表中的一个位置来访问记录，加快访问速度。

- 映射函数也叫离散函数（Hash Function），存放记录的数组叫做哈希表（或离散表）。

![image-20200619154400509](/Users/luozhengqi/Library/Application Support/typora-user-images/image-20200619154400509.png)

- 哈希函数选的好，可以使数值尽量分散，减少指针碰撞

- 哈希碰撞：不同数据哈希后，产生相同hash值。使用哈希链表解决，时间复杂度近似O(1)，和size大小有关。

### Java Set

- 实现不同时间复杂度不同，HashSet.contains O(1)。TreeSet.contains() O(logn)

- TreeSet 
  - 关键字：transient，不需要序列化的变量
  - TreeSet 底层存放数据使用 TreeMap，利用TreeMap的key值存放，value为占位空间（PRESENT），没有实际值。
- HashSet
  - 和TreeSet设计思想相同，底层数据结构使用HashMap。

### Java Map

1. new HashMap(); 参考文档：https://blog.csdn.net/qq_38182963/article/details/78942764

- 初始化容器：tableSizeFor(); 计算阈值，确定容量大小，此时容量大小为2的幂次方，否则会有不好的结果（*可补充*）。牛逼的算法，找到当前值最近的2幂次方值为容量大小。

```
static final int tableSizeFor(int var0) {
    int var1 = var0 - 1;
    var1 |= var1 >>> 1;
    var1 |= var1 >>> 2;
    var1 |= var1 >>> 4;
    var1 |= var1 >>> 8;
    var1 |= var1 >>> 16;
    return var1 < 0 ? 1 : (var1 >= 1073741824 ? 1073741824 : var1 + 1);
}

例子：
10 = 1010；
n = 9;

二进制表示
1001 == 9；

1001 >>> 1 = 0100;
1001 或 0100 = 1101；

1101 >>> 2 = 0011;
110 或 0011 = 1111；

1111 >>> 4 = 0000;
1111 或 0000 = 1111；

1111 >>> 8 = 0000;
1111 或 0000 = 1111；

1111 >>> 16 = 0000；
1111 或 0000 = 1111；

最后，1111 也就是 15 ，15 + 1 = 16
```

1. HashMap.get();
2. HashMap.put();

- 通过hash计算下标，并检查是否冲突

  - hash值得生成 -- hash方法（哈希&离散方法）：(h = key.hashCode()) ^ (h >>> 16)；保证尽可能离散，jdk在此有性能上选择，有极个别情况hash值还会重复。

  ```java
  final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                 boolean evict) {
      Node<K,V>[] tab; Node<K,V> p; int n, i;
      // 为空则初始化数组
      if ((tab = table) == null || (n = tab.length) == 0)
          n = (tab = resize()).length;
      // 判断当前hash值指向地址是否已经有值，没有则根据key-value创建
      if ((p = tab[i = (n - 1) & hash]) == null)
          tab[i] = newNode(hash, key, value, null);
      else {
          Node<K,V> e; K k;
          // hash值相等 与 key地址相等或key值相等 则覆盖value值返回
          if (p.hash == hash &&
              ((k = p.key) == key || (key != null && key.equals(k))))
              e = p;
          // 
          else if (p instanceof TreeNode)
              e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
          else {
          		// 循环，判断链表长度，决定hash值碰撞后数据存放结构
              for (int binCount = 0; ; ++binCount) {
              		// 链表长度在8以内，也就是链表长度最多为7，出现空的情况则放入key-value元素，此时放入链表中
                  if ((e = p.next) == null) {
                      p.next = newNode(hash, key, value, null);
                      // hash碰撞超过7次，链表长度到达8，数组长度小于64则重新离散，大于64转红黑树
                      if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                          treeifyBin(tab, hash);
                      break;
                  }
                  // 出现 hash值相等 与 key地址相等或key值相等 则覆盖value值返回
                  if (e.hash == hash &&
                      ((k = e.key) == key || (key != null && key.equals(k))))
                      break;
                  p = e;
              }
          }
          if (e != null) { // existing mapping for key
              V oldValue = e.value;
              if (!onlyIfAbsent || oldValue == null)
                  e.value = value;
              afterNodeAccess(e);
              return oldValue;
          }
      }
      ++modCount;
      if (++size > threshold)
          resize();
      afterNodeInsertion(evict);
      return null;
  }
  ```
  
  - 链表长度到达8时，则需要重新离散或者转红黑树结构存储
  
  ```java
  final void treeifyBin(Node<K,V>[] tab, int hash) {
      int n, index; Node<K,V> e;
      // 链表长度达到8，数组长度（存放元素值）小于64，重新离散
      if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
          resize();
      // 转红黑树结构 （学了数算法结构在做补充）
      else if ((e = tab[index = (n - 1) & hash]) != null) {
          TreeNode<K,V> hd = null, tl = null;
          do {
              TreeNode<K,V> p = replacementTreeNode(e, null);
              if (tl == null)
                  hd = p;
              else {
                  p.prev = tl;
                  tl.next = p;
              }
              tl = p;
          } while ((e = e.next) != null);
          if ((tab[index] = hd) != null)
              hd.treeify(tab);
      }
  }
  ```
  
  

### 算法做题思路 4步

1. 问清楚题目
2. 最优解法，时间复杂度O
3. 写代码
4. 测试案例

### 整理自己代码库，学习、工作中遇到好的代码进行整理

### 实战题目

1. 有效的字母异位词：https://leetcode-cn.com/problems/valid-anagram/description/
   - 暴力：sort 先排序，再判断是否相等。O(nlogn)
   - 哈希表：new int[26] -> char - ‘a’。O(n)
2. 字母异位词分组：https://leetcode-cn.com/problems/group-anagrams/
   - 暴力：循环 -> 排序，利用Map存储，key值为排序后字符串。O(K*NlonN)
   - 哈希表：循环 -> new int[26] -> char - ‘a’，利用Map存储，key值为“0#1#2#0#”（循环int26拼接）。O(K*N)
   - 个人理解：此处哈希表并不具体指具体数据结构（比如HashMap），而是利用hash值思想构建不重复的元素。
3. 两数求和：https://leetcode-cn.com/problems/two-sum/
   - 补充hash算法：两遍哈希和一遍哈希解法。O(n)

## 第六课 树|二叉树|二叉搜索树

- Linked List 是特殊化的Tree，两个或多个下一节点
- Tree 是特殊化的 Graph（图）

- 树节点定义

  ```java
  public class TreeNode{
    	private Object o;
    	private TreeNode leftNode,rightNode;
    	
    	public void TreeNode(Object val){
        	this.o = val;
        	this.leftNode = null;
        	this.rightNode = null;
      }
  }
  ```

- 树的遍历：（前中后只根所在位置）

  - 前序：根 - 左 - 右
  - 中序：左 - 根 - 右
  - 后序：左 - 右 - 根

### 二叉搜索树

- 左子树上所有节点的值小于根节点的值
- 右子树上所有节点的值大于根节点的值
- 中序遍历：升序排列

### 实战题目

- 掌握前序、中序和后序的实现代码 递归&&迭代

  - 前序

    ```java
    public void preOrderTraverse1(TreeNode root) {
      	if (root != null) {
        		System.out.print(root.val + "->");
        		preOrderTraverse1(root.left);
        		preOrderTraverse1(root.right);
      	}
    }
    ```

  - 中序

    ```java
    public void inOrderTraverse(TreeNode root) {
      	if (root != null) {
        		inOrderTraverse(root.left);
        		System.out.print(root.val + "->");
        		inOrderTraverse(root.right);
      	}
    }
    ```

  - 后序

    ```java
    public void postOrderTraverse(TreeNode root) {
      	if (root != null) {
            postOrderTraverse(root.left);
            postOrderTraverse(root.right);
            System.out.print(root.val + "->");
      	}
    }
    ```

    

## 堆|二叉堆|图

### 堆

- heap：可以迅速找到最大或者最小值的数据结构。根节点最大叫大顶堆，根节点最小叫小顶堆。常见二叉堆和斐波拉契堆。
- 大顶堆：
  - find-max：O(1)
  - delete：O(logn)
  - insert(create)：O(logn) or O(1)，严格的斐波拉契堆可以达到O(1)
  - ![image-20200621200714320](/Users/luozhengqi/Library/Application Support/typora-user-images/image-20200621200714320.png)

### 二叉堆

- 是一颗完全数，除了叶子节点，其他节点均是满的。树中任意节点值大于等于其子节点值。
- 通过数组实现，并满足一定关系
  - 索引为 i 的左子节点的索引是：2 * i + 1
  - 索引为 i 的右子节点的索引是：2 * i + 2
  - 索引为 i 的根节点的索引是：(i - 1) / 2

- insert 操作 O(logn)
  - 新元素一律插入到堆的尾部
  - 依次向上调整数的结构，直到根即可
  - HeapifyUp
- Delete max 操作O(logn)
  - 将堆尾元素替换到顶部
  - 从根部依次向下调整树的结构，直到尾部即可
  - HeapifyDown
- 二叉堆是堆（优先队列）的一种常见切简单的实现，但不是最优实现

### 实战题目

- 最小的k个数：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
  - 
- 滑动窗口最大值：https://leetcode-cn.com/problems/sliding-window-maximum/



### 图

- Graph(V, E)
- V - vertex：点
  - 度 - 入度和出度
  - 点于点之间是否连通
- E - edge：边
  - 有向和无向（单行线）
  - 权重（边长）



## 思考题

- 树的面试题一般都是考察递归，为什么
  - 和树的数据结构有关，每个节点有可能既是其他节点的子节点，又是某个节点的根节点，具有重复性

