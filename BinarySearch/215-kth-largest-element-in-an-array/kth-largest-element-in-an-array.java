class Solution {
    /**Time Complexity - O(N*LogN) 
        Space Complexity - O(N)*/
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);

        int size = nums.length;

        if(k>size)
            return Integer.MIN_VALUE;

        for(int index=0; index<size; index++){// O(N*Log N)
            maxHeap.add(nums[index]);//O(Log N)
        }

        int kthLargestElement = maxHeap.peek();
        while(k>0 && !(maxHeap.isEmpty())){
            kthLargestElement = maxHeap.poll();
            k--;
        }
        return kthLargestElement;
    }
}