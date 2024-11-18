class Solution {
    public int maxSubArray(int[] nums) {
        int size = nums.length;

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        int start=-1, end=-1, currStart=-1;
        for(int i=0; i<size; i++){

            // Needed for Length of subarray or to print max subarray 
            // if(currSum == 0)
            //     currStart = i;

            currSum += nums[i];
            //Needed for Length of subarray or to print max subarray
            // if(maxSum<currSum){
            //     maxSum = currSum;

            //     start = currStart;
            //     end = i;
            // }
            maxSum = Math.max(maxSum, currSum);
            if(currSum < 0) currSum = 0;
        }

        // System.out.println("start="+start+" end="+end);

        return maxSum;
    }
}