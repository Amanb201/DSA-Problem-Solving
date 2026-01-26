class MyLinkedList {
    class Node{
        int val;
        Node next;

        Node(int _val){
            this.val = _val;
        }
    }

    Node head;

    public MyLinkedList() {
        head = new Node(-1);
    }
    
    public int get(int index) {
        Node curr = head.next;

        int currInd = 0;
        while(currInd<index && curr!=null){
            curr = curr.next;
            currInd++;
        }

        if(currInd == index && curr!=null)
            return curr.val;
        return -1;
    }
    
    public void addAtHead(int val) {
        Node nextNode = head.next;
        head.next = new Node(val);
        head.next.next = nextNode;
    }
    
    public void addAtTail(int val) {
        Node curr = head;
        while(curr.next!=null){
            curr = curr.next;
        }

        curr.next = new Node(val);
    }
    
    public void addAtIndex(int index, int val) {
        Node curr = head;
        int currInd = 0;

        while(currInd<index && curr!=null){
            currInd++;
            curr = curr.next;
        }

        if(currInd == index && curr!=null){
            Node nextNode = curr.next;
            curr.next = new Node(val);
            curr.next.next = nextNode;
        }
    }
    
    public void deleteAtIndex(int index) {
        Node curr = head;
        int currInd = 0;

        while(currInd<index && curr!=null){
            currInd++;
            curr = curr.next;
        }

        if(currInd == index && curr!=null && curr.next != null){
            Node nextNode = curr.next;
            curr.next = nextNode.next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */