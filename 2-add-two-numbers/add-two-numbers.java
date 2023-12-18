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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
        Time Complexity - O(size(l1)+size(l2))
        Space Complexity - O(size(l1)+size(l2)) */
        int carry = 0;

        ListNode head = null, curr;
        curr =null;
        ListNode first = l1, second = l2;

        while(first != null && second != null){
            int number = first.val + second.val +carry;

            carry = number/10;
            number = number%10;

            if(curr == null)
            {
                curr = new ListNode(number, null);
                head = curr;
            }    
            else{
                curr.next  = new ListNode(number, null);
                curr = curr.next;
            }
            first = first.next;
            second = second.next;
        }

        while(first != null){
            int number = first.val + carry;
            carry = number/10;
            number = number%10;
            
            curr.next  = new ListNode(number, null);
            curr = curr.next;
            
            first = first.next;
        }

        while(second != null){
            int number = second.val + carry;
            carry = number/10;
            number = number%10;
            
            curr.next  = new ListNode(number, null);
            curr = curr.next;
            
            second = second.next;
        }

        if(carry>0)
            curr.next  = new ListNode(carry, null);

        return head;
    }
}