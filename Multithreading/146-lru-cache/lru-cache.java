class LRUCache {
    class Node {
        int key, val;
        Node next, prev;

        Node (int _key, int _val){
            this.key = _key;
            this.val = _val;
        }
    }

    Node head, tail;
    int capacity;

    Map<Integer, Node> keyNodeMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;

        keyNodeMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(!keyNodeMap.containsKey(key)) return -1;

        Node currNode = keyNodeMap.get(key);

        deleteNode(currNode);
        insertNodeAfterHead(currNode);

        return currNode.val;
    }
    
    public void put(int key, int value) {
        if(keyNodeMap.containsKey(key)){
            Node currNode = keyNodeMap.get(key);
            currNode.val = value;

            deleteNode(currNode);
            insertNodeAfterHead(currNode);
        }
        else if(keyNodeMap.size() == capacity){
            Node lruNode = tail.prev;
            keyNodeMap.remove(lruNode.key);

            deleteNode(lruNode);
            Node newNode = new Node(key, value);
            keyNodeMap.put(key, newNode);
            insertNodeAfterHead(newNode);
        }
        else{
            Node newNode = new Node(key, value);
            keyNodeMap.put(key, newNode);
            insertNodeAfterHead(newNode);
        }
    }

    private void deleteNode(Node currNode){
        Node prevNode = currNode.prev;
        Node nextNode = currNode.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void insertNodeAfterHead(Node newNode){
        Node nextNode =head.next;
        head.next = newNode;
        newNode.next = nextNode;
        newNode.prev = head;

        nextNode.prev = newNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */