class LFUCache {
    class Node {
        int key, val, freq;
        Node next, prev;

        Node(int _key, int _val){
            this.key = _key;
            this.val = _val;
            this.freq = 1;
        }
    }

    class LRUDoublyLinkedList {
        Node head, tail;
        int size;

        LRUDoublyLinkedList (){
            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;
        }

        public void addNodeToFront (Node currNode){
            Node nextNode = head.next;
            head.next = currNode;
            currNode.prev = head;
            currNode.next = nextNode;
            nextNode.prev = currNode;

            size++;
        }

        //Cache Evict
        public void deleteNode (Node currNode){
            Node prevNode = currNode.prev;
            Node nextNode = currNode.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }
    }

    int capacity, currCapacity, minFreq;

    Map<Integer, Node> keyNodeMap;
    Map<Integer, LRUDoublyLinkedList> frequencyDllMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyNodeMap = new HashMap<>();
        frequencyDllMap = new HashMap<>();
    }
    
    public int get(int key) {
        if( !keyNodeMap.containsKey(key)) return -1;

        Node currNode = keyNodeMap.get(key);

        updateNodeAccess(currNode);

        return currNode.val;
    }
    
    public void put(int key, int value) {
        if(keyNodeMap.containsKey(key)){
            Node currNode = keyNodeMap.get(key);
            currNode.val = value;

            updateNodeAccess(currNode);
        }
        else if(currCapacity == capacity){
            LRUDoublyLinkedList lruDoublyLL = frequencyDllMap.get(minFreq);

            Node lfuNode = lruDoublyLL.tail.prev;
            keyNodeMap.remove(lfuNode.key);
            lruDoublyLL.deleteNode(lfuNode);

            if(lruDoublyLL.size == 0){
                frequencyDllMap.remove(minFreq);
                minFreq++;
            }

            Node newNode = new Node(key, value);
            addNewNode(newNode);
        }
        else {
            Node newNode = new Node(key, value);
            addNewNode(newNode);
            currCapacity++;
        }
    }

    private void addNewNode(Node newNode){
        keyNodeMap.put(newNode.key, newNode);

        minFreq = 1;
        LRUDoublyLinkedList lruDoublyLLNew = frequencyDllMap.getOrDefault(minFreq, new LRUDoublyLinkedList());
        lruDoublyLLNew.addNodeToFront(newNode);
        frequencyDllMap.put(minFreq, lruDoublyLLNew);
    }

    private void updateNodeAccess(Node currNode){
        int freq = currNode.freq;
        currNode.freq = freq+1;

        LRUDoublyLinkedList lruDoublyLL = frequencyDllMap.get(freq);
        lruDoublyLL.deleteNode(currNode);

        if(lruDoublyLL.size == 0){
            frequencyDllMap.remove(freq);
            if(freq == minFreq) minFreq++;
        }

        LRUDoublyLinkedList lruDoublyLLUpdated = frequencyDllMap.getOrDefault(freq+1, new LRUDoublyLinkedList());
        lruDoublyLLUpdated.addNodeToFront(currNode);
        frequencyDllMap.put(freq+1, lruDoublyLLUpdated);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */