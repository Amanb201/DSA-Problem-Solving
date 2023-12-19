/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        //Time Complexity - O(N) //Worst Case first element needs to be deleted
        //Space Complexity -O(1)
        
        ListNode curr = node;
        
        while(curr.next != null){
            curr.val = curr.next.val;

            if(curr.next.next == null){
                curr.next = null;
                break;
            }
            else
                curr =curr.next;
        }
    }
}