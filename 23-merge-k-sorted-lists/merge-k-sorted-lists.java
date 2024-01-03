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
/**Time Complesxity - O(K Log K) //For loop initialization of minHeap with heads of lists
                            +          Let total No of Nodes in resultant list = N; 
                    O(M*K Log K ) Then N = M*K (assuming M is the maximum number of Nodes in any List)*/ 

    public ListNode mergeKSortedLists(PriorityQueue<Pair<Integer, ListNode>> minHeap){
        ListNode head=null, curr=null,prev=null;
        
        //There are K lists and assuming at max M nodes are there in one list
        //K*M times or nodes need to go In and Out of the MinHeap.So, this many times while loop would execute
        while(minHeap.peek() != null){
            Pair<Integer, ListNode> nodePair = minHeap.poll();
            curr = nodePair.getValue();

            if(head == null){
                head=curr;
            }
            else{
                prev.next = curr;
            }
            prev = curr;

            if(curr.next != null){
                Pair<Integer, ListNode> newNodePair = new Pair<>(curr.next.val, curr.next);
                minHeap.add(newNodePair); //O((Log K) at max K nodes would be present in MinHeap )
            }
        }
        return head;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)   return null;
        
        PriorityQueue<Pair<Integer, ListNode>> minHeap = new PriorityQueue<>((a,b)->a.getKey()-b.getKey());
        
        ListNode currHead = lists[0];

        //Inserting all the heads of lists into Min Heap
        for(int index=0; index<lists.length; index++){ //O(K)xO(Log K)
            if(lists[index] != null){
                Pair<Integer, ListNode> nodePair = new Pair<>(lists[index].val, lists[index]);
                minHeap.add(nodePair);  //O(Log K)
            }
        }

        return mergeKSortedLists(minHeap);
    }
}