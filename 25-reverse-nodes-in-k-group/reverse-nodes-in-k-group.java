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
    /***Time  Complexity - O(N)
    N time finding Kth Node and N time for reversal, all other constant operations 
    Space Complexity - O(1)*/

    public ListNode reverseList (ListNode head){
        if(head == null) return null;

        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode nextNode = curr.next;

            curr.next = prev;
            prev = curr;
            
            curr = nextNode;
        }
        return prev;
    }

    public ListNode findKthNode(ListNode head, int k){
        ListNode curr = head;
        while(curr != null && k > 1){
            curr = curr.next;
            k--;
        }

        if(curr == null & k>1)
            return null;
        else
            return curr;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head, nextNode, prevNode=null;

        while(curr != null){

            ListNode kNode = findKthNode(curr, k);

            if(kNode == null){
                if(prevNode != null)
                    prevNode.next = curr;
                break;
            }

            nextNode = kNode.next;
            kNode.next = null;

            reverseList(curr);

            if(curr == head)
                head = kNode;
            else
                prevNode.next = kNode;

            prevNode = curr;
            curr = nextNode;
        }
        return head;
    }
}