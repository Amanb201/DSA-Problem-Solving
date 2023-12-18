/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        /**
        Time Compelxity - O(N/2) = O(N)
        Space Complexity - O(1) */
        ListNode fast = head, slow = head;

        while(fast != null && slow != null){
            if(fast.next == null)
                return slow;
            
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}