class LRUCache {
    int capacity;
    int currSize;

    Node head;
    Node tail;

    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.currSize = 0;
        
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;

        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if(this.map.containsKey(key)){
        //Get the value from the map and keep the element somewhere
            Node currNode = this.map.get(key);
        //Find that node in the LL and delete it.
            this.deleteNode(currNode);
        //Add that value as new node in the front of LL
            this.addNodeAtFront(currNode);
        //Update the Map's value with new node.
            
            return currNode.value;
        }
        else
            return -1;
    }
    
    public void put(int key, int value) {
        //If element already exists but value needs to be updated
        if(this.map.containsKey(key)){
        //Get the value from the map and keep the element somewhere
            Node oldValNode = this.map.get(key);
        //Find that node in the LL and delete it.
            this.deleteNode(oldValNode);
            this.map.remove(key);
        //Add that value as new node in the front of LL
            this.addNodeAtFront(new Node(key, value));
        //Update the Map's value with new node.
            this.map.put(key, head.next);
        }
        else if(this.currSize<this.capacity){
            //if capacity is available and new element is Pushed
            Node currNode = new Node(key, value);

            this.addNodeAtFront(currNode);
            this.map.put(key, head.next);
            currSize++;
        }
        else{
            //if capacity is full and new element is Pushed
            //Get the last item of linked list and delete it
            Node deletedNode = tail.prev;
            this.deleteNode(tail.prev);

            //remove the entry corresponding to the same value in the Hashmap
            this.map.remove(deletedNode.key);

            //Add item to the linked list front
            this.addNodeAtFront(new Node(key, value));
            //Add item to the Hashmap
            this.map.put(key, head.next);
        }
    }

    public void addNodeAtFront(Node currNode){
        Node nextNode = head.next;
        currNode.next = nextNode;
        nextNode.prev = currNode;
        head.next = currNode;
        currNode.prev = head;
    }

    public void deleteNode(Node currNode){
        Node nextNode = currNode.next;
        nextNode.prev =currNode.prev;
        currNode.prev.next = nextNode;
    }
}

class Node{
    int key;
    int value;
    Node next;
    Node prev;

    Node(int _key, int _value){
        this.key = _key;
        this.value = _value;
        this.next = null;
        this.prev = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */