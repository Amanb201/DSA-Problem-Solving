class KthLargest {
    Queue<Integer> minHeap = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num: nums){
            if(minHeap.size()<k){
                minHeap.add(num);
            }
            else if(minHeap.peek()<num){
                minHeap.poll();
                minHeap.add(num);
            }
        }
    }
    
    /**Time Complexity - O(1) */
    public int add(int val) {
        if(minHeap.size()<k){
            minHeap.add(val);
        }
        else if(minHeap.peek()<val){
            minHeap.poll();
            minHeap.add(val);
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */