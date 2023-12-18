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
    public ListNode reverseList(ListNode head) {
        /**
        Time Complexity - O(N)
        Space Complexity - O(1) */
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null && curr.next != null){
            ListNode temp = curr;
            curr = curr.next;

            temp.next = prev;

            prev = temp;
        }
        if(curr != null){
            curr.next = prev;
            return curr;
        }
        
        return curr;
    }
}