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
    public boolean isPalindrome(ListNode head) {
        ListNode reverseLinkedList = null;

        ListNode curr = head;        
        while(curr != null){
            if(reverseLinkedList == null){
                reverseLinkedList = new ListNode(curr.val, null);
            }else{
                reverseLinkedList = new ListNode(curr.val, reverseLinkedList);
            }
            curr = curr.next;
        }

        ListNode head1 =head, head2 = reverseLinkedList;
        while(head1 != null && head2 !=null){
            if(head1.val == head2.val){
                head1 = head1.next;
                head2 = head2.next;
            }
            else
                return false;
        }

        return true;
    }
}