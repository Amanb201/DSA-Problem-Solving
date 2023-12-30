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
    /**Time Complexity - O(N) for iterating over LL to make it's copy
                          +
                         O(N) for iterating over LL to set the next and random pointer in the
                         copied LL
       Space Complexity - O(N) for Map */
    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();

        Node curr = head;

        if(curr == null)
            return null;

        while(curr != null){
            Node copyNode = new Node(curr.val);
            nodeMap.put(curr, copyNode);
            curr = curr.next;
        }

        curr=head;
        while(curr != null){
            Node copy = nodeMap.get(curr);

            copy.next = nodeMap.get(curr.next);
            copy.random = nodeMap.get(curr.random);

            curr = curr.next;
        }

        return nodeMap.get(head);
    }
}