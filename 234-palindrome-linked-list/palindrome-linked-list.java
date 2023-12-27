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
        Stack<Integer> stack = new Stack<Integer>();

        int countLen = 0;

        ListNode curr = head;
        while(curr != null){
            countLen++;
            curr = curr.next;
        }
        
        if(countLen == 1)
            return true;

        int mid = countLen/2;

        curr = head;
        int index = 0;
        while(curr != null){
            index++;
            if(index <= mid)
                stack.push(curr.val);
            else if(countLen % 2 != 0 && index == mid+1){
                //skip the mid element in case of total odd elements
            }
            else{
                if(!stack.empty()){
                    int top = stack.pop();

                    if(top != curr.val)
                        return false;
                }
            }
            curr = curr.next;
        }

        return stack.empty();
    }
}