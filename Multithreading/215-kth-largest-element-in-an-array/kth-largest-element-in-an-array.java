class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for(int num: nums)
            pq.add(num);

        int ans = -1;
        while(k>0 && pq.isEmpty() == false){
            ans = pq.poll();
            k--;
        }

        return ans;
    }
}