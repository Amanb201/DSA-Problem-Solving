class Solution {
    public int maxSubArray(int[] nums) {
        int size = nums.length;

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i=0; i<size; i++){
            currSum += nums[i];

            maxSum = Math.max(maxSum, currSum);
            if(currSum < 0) currSum = 0;
        }

        return maxSum;
    }
}