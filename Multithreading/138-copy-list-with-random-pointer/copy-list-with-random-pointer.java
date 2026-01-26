/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // return betterApproach(head);
        return optimalApproach(head);
    }

    private Node optimalApproach (Node head){
        Node curr = head;
        
        //Step-1 Create Copy Node and attach just next to the original node
        while(curr != null){
            Node copyNode = new Node(curr.val);
            insertNodeNextToCurrent(curr, copyNode);

            curr = curr.next.next;
        }

        curr = head;
        //Step-2 Connect Random Pointers to CopyNodes
        while(curr != null){
            Node copyNode = curr.next;
            Node copyRandomNode = curr.random!=null ? curr.random.next : null;

            copyNode.random = copyRandomNode;

            curr = curr.next.next;
        }

        //Step-3 Connect Next Pointers in the Copy List and Retrieve the Original List Pointers
        curr = head;
        Node copyHead = new Node(-1);
        Node copyCurr = copyHead;

        while(curr != null){
            copyCurr.next = curr.next;
            curr.next = curr.next.next;

            copyCurr = copyCurr.next;
            curr = curr.next;
        }

        return copyHead.next;
    }

    private void insertNodeNextToCurrent(Node currNode, Node copyNode){
        Node nextNode = currNode.next;
        currNode.next = copyNode;
        copyNode.next = nextNode;
    }

    //Time complexity - O(2*N) 2 time travesing List
    //Space Complexity - O(2*N) 1 Hashmap and 1 Copy List
    private Node betterApproach(Node head){
        Map<Node, Node> copyNodeMap = new HashMap<>();

        Node curr = head;

        if(head==null) return null;

        while(curr!=null){
            Node copyNode = new Node(curr.val);

            copyNodeMap.put(curr, copyNode);
            curr = curr.next;
        }

        curr = head;
        while(curr!=null){
            Node copyNode = copyNodeMap.get(curr);

            copyNode.next = copyNodeMap.get(curr.next);
            copyNode.random = copyNodeMap.get(curr.random);

            curr = curr.next;
        }

        return copyNodeMap.get(head);
    }
}