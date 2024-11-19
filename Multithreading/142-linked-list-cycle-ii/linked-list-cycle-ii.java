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
    public ListNode detectCycle(ListNode head) {
        // Map<ListNode, Integer> nodeTimestamp = new HashMap<>();
        // ListNode slow = head, ne;
        // int index = 0;
        // nodeTimestamp.put(head, index);
        // while(slow != null){
        //     slow = slow.next;

        //     // == operator will compare the addresses of the objects
        //     // we can also use .equals() method, by default this also compares address of the objects
        //     // but we can override it's implementation
        //     if(nodeTimestamp.containsKey(slow)){
        //         return slow;
        //     }

        //     nodeTimestamp.put(slow, index);
        //     index++;
        // }

        // return null;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;

        /**
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
        
        
         */
    }
}