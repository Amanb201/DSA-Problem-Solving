/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stack1 = new Stack<ListNode>();
        Stack<ListNode> stack2 = new Stack<ListNode>();

        ListNode currA = headA, currB = headB;

        while(currA != null){
            stack1.push(currA);
            currA = currA.next;
        }

        while(currB != null){
            stack2.push(currB);
            currB = currB.next;
        }

        if(stack1.peek() != stack2.peek())
            return null;

        ListNode answer = null;
        while(!stack1.empty() && !stack2.empty()){
            ListNode top1 = stack1.pop();
            ListNode top2 = stack2.pop();

            if(top1 == top2)
                answer = top1;
            else
                break;
        }
        return answer;
    }
}