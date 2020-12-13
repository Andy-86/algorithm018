class LRUCache {
    int capacity;

    DNode head;

    DNode tail;

    Map<Integer, DNode> cache;

    int size;

    class DNode {
        int key;

        int value;

        DNode pre;

        DNode next;

    }

    public LRUCache(int capacity) {
        head = new DNode();
        tail = new DNode();
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public int get(int key) {
        DNode node = cache.get(key);
        if (node != null) {
            add2Head(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        DNode node = cache.get(key);
        if (node == null) {
            node = new DNode();
            node.key = key;
            node.value = value;
            addHead(node);
            cache.put(key, node);
            size++;
            // 超过capacity则remove 最后一个
            if (size > capacity) {
                DNode tailNode = removeTail();
                cache.remove(tailNode.key);
                size--;
            }
        } else if (node.value != value) {
            node.value = value;
            add2Head(node);
        } else {
            add2Head(node);
        }
    }

    public void addHead(DNode node) {
        node.pre = head;
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
    }

    public void removeNode(DNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void add2Head(DNode node) {
        removeNode(node);
        addHead(node);
    }

    public DNode removeTail() {
        DNode tem = tail.pre;
        tail.pre = tail.pre.pre;
        tail.pre.next = tail;
        return tem;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
