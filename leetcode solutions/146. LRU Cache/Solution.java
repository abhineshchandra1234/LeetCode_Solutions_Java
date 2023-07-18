/**
 * 146. LRU Cache
 * 
 * Intuition
 * 
 * credits liaison
 * we will solve this problem using double linked list.
 * It will have a head and tail and all the data will be stored between them
 * We will add new data just after head, and also bring recently accessed data
 * right after head
 * Least recently used data will towards tail end.
 * we will also use hashmap to store key as data key and value as double linked
 * list object with all the data.
 * We used double linked list, as we can delete node in this without any
 * reference
 * It takes constant time to add or remove node from head or tail
 * 
 * Approach
 * 
 * //LRUCache lRUCache = new LRUCache(2);
 * head .. tail
 * //lRUCache.put(1, 1);
 * head (1,1) tail
 * //lRUCache.put(2, 2);
 * head (2,2), (1,1) tail
 * //lRUCache.get(1);
 * head (1,1), (2,2) tail -> return 1
 * //lRUCache.put(3, 3);
 * head (3,3), (1,1) tail -> remove 2
 * //lRUCache.get(2);
 * head (3,3), (1,1) tail -> return -1 (not found)
 * //lRUCache.put(4, 4);
 * head (4,4), (3,3) tail -> remove 1
 * //lRUCache.get(1);
 * head (4,4), (3,3) tail -> return -1 (not found)
 * //lRUCache.get(3);
 * head (3,3), (4,4) tail -> return 3
 * //lRUCache.get(4);
 * head (4,4), (3,3) tail -> return 4
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * get -> O(1), hashmap fetches the data
 * 
 * put -> O(1), new data will be inserted right after head in linked list.
 * 
 * Space complexity: O(n)
 * 
 */
class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    // add new node right after head
    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    // remove an existing node from linked list
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    // move certain node right after head
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    // pop the current tail
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    private HashMap<Integer, DLinkedNode> cache = new HashMap();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {

        DLinkedNode node = cache.get(key);

        // raise exception here
        if (node == null)
            return -1;

        // move accessed node right after head
        this.moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {

        DLinkedNode node = cache.get(key);

        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            count++;

            if (count > capacity) {
                // pop the tail
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                count--;
            }
        } else {
            // update the value
            node.value = value;
            this.moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */