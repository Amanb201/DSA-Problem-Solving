/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**Time Complexity - O(N) To find the first meeting node
                          + 
                         O(N) To find the intersection
        Space Complexity - O(N) stack space; 
                         */
    ListNode slowNFastMeetNode(ListNode head) {
        ListNode fast = head, slow = head;

        if(head == null) return null;

        boolean firstIter = true;

        while(slow!=null && fast != null && fast.next != null){
 
            if(!firstIter && slow == fast )
                return slow;
            
            firstIter = false;

            slow = slow.next;
            fast = fast.next.next;
        }

        if(slow == null || fast == null || fast.next == null)    return null;

        return null;
    }

    ListNode findIntersectionofSlow1NSlow2(ListNode slow1, ListNode slow2){
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();

        while(slow1 != null && slow2 != null){
            stackA.push(slow1);
            stackB.push(slow2);
            
            if(slow1 == slow2)
                break;

            slow1 = slow1.next;
            slow2 = slow2.next;
        }

        ListNode intersection = null;

        while(!stackA.empty() && !stackB.empty()){
            ListNode nodeA = stackA.pop();
            ListNode nodeB = stackB.pop();

            if(nodeA == nodeB)
                intersection = nodeA;
            else
                return intersection;
        }
        return intersection;
    }
    public ListNode detectCycle(ListNode head) {
        ListNode slow1 = head;
        ListNode slow2 = slowNFastMeetNode(head);
        
        if(head == null || slow2 == null) return null;
        
        return findIntersectionofSlow1NSlow2(slow1, slow2);
    }
}