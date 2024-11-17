class Solution {
    public int shortestSubarray(int[] nums, int k) {

        /**
            int minNum = -1;

            for(int i=0; i<nums.length; i++){
                int currSum = 0;
                for(int j=i; j< nums.length; j++){
                    currSum += nums[j];

                    if(currSum >= k){
                        int currLen = j-i+1; 
                        if(minNum == -1)
                            minNum = currLen;
                        else
                            minNum = Math.min(minNum, currLen);
                    }
                }
            }

            return minNum;
        */

        int n = nums.length;

        // Initialize result to the maximum possible integer value
        int shortestSubarrayLength = Integer.MAX_VALUE;

        long cumulativeSum = 0;

        // Min-heap to store cumulative sum and its corresponding index
        PriorityQueue<Pair<Long, Integer>> prefixSumHeap = new PriorityQueue<>(
            (a, b) -> Long.compare(a.getKey(), b.getKey())
        );

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Update cumulative sum
            cumulativeSum += nums[i];

            // If cumulative sum is already >= k, update shortest length
            if (cumulativeSum >= k) {
                shortestSubarrayLength = Math.min(
                    shortestSubarrayLength,
                    i + 1
                );
            }

            // Remove subarrays from heap that can form a valid subarray
            while (
                !prefixSumHeap.isEmpty() &&
                cumulativeSum - prefixSumHeap.peek().getKey() >= k
            ) {
                // Update shortest subarray length
                shortestSubarrayLength = Math.min(
                    shortestSubarrayLength,
                    i - prefixSumHeap.poll().getValue()
                );
            }

            // Add current cumulative sum and index to heap
            prefixSumHeap.offer(new Pair<>(cumulativeSum, i));
        }

        // Return -1 if no valid subarray found
        return shortestSubarrayLength == Integer.MAX_VALUE
            ? -1
            : shortestSubarrayLength;
    }
}