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
    public boolean hasCycle(ListNode head) {
        /**
        Time Complexity - O(N)
        Space Complexity - O(1) */
        boolean isCycleExist = false;

        ListNode slow = head, fast = head;
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow != null && fast != null && slow == fast)
                return true;
        }
        return false;
    }
}