import java.util.HashMap;

/**
 * 146. LRU缓存机制
 * @ClassName LRUCache
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-29 23:30
 * @Version 1.0
 **/
class LRUCache {

    class DLinkedNode{
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode() {
        }
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int size;
    int capacity = 0;
    HashMap<Integer, DLinkedNode> cache;
    DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        removeToFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addFirst(newNode);
            size++;
            if(size > capacity){
                DLinkedNode reNOde = removeLast();
                cache.remove(reNOde.key);
                size--;
            }
        }else{
            node.value = value;
            removeToFirst(node);
        }
    }

    private DLinkedNode removeLast() {
        DLinkedNode res = tail.pre;
        removeNode(res);
        return res;
    }

    private void removeNode(DLinkedNode res) {
        res.pre.next = res.next;
        res.next.pre = res.pre;
    }

    private void addFirst(DLinkedNode newNode) {
        newNode.pre = head;
        newNode.next = head.next;
        head.next.pre = newNode;
        head.next = newNode;
    }

    private void removeToFirst(DLinkedNode node) {
        removeNode(node);
        addFirst(node);
    }
}
