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
        return betterApproach(head);
    }


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