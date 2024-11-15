class Solution {
    public int findKthLargest(int[] nums, int k) {
        /**
        //Appoach-1:  O(NLogN) using N size Queue(MaxHeap for Kth largest element)
        Queue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for(int num: nums)
            pq.add(num);

        int ans = -1;
        while(k>0 && pq.isEmpty() == false){
            ans = pq.poll();
            k--;
        }

        return ans;
         */

        //Approach-2 
        //Use MinHeap only to find Kth largest Element. with K size queue.

        //Edge cases
        if(k>nums.length)
            return -1;

        Queue<Integer> pq = new PriorityQueue<>();

        for(int num: nums){
            if(pq.size()<k){
                pq.add(num);
            }
            else if(pq.peek()<num){
                pq.poll();
                pq.add(num);
            }
        }

        return pq.peek();
        
    }
}