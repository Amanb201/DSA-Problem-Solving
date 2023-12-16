class Solution {
    public int maxSubArray(int[] nums) {
        /**
            Naive Approach/ Brute Force
            Time Complexity = O(N^2)
            Space Complexity = O(1)
         */
        /**
        Naive Brute Force approach.
        int currMax= nums[0];
        //Trying out all the Subarrays sum and checking for maxSum.
        //Generating all subarray sum.
        for(int i=0; i<nums.length; i++){
            if(nums[i]>currMax)
                currMax=nums[i];

            int currSum=nums[i];    
            for(int j=i+1; j<nums.length; j++){
                currSum+=nums[j];

                if(currMax<currSum){
                    currMax=currSum;
                }
            }
        }
        return currMax; 
        */

        //Kadane's Algorithm'
        //Time Complexity - O(N)
        //Space Complexity - O(1)
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int index = 0; index<nums.length; index++){
            currSum += nums[index];

            if(currSum>maxSum)
                maxSum = currSum;

            if(currSum<0)
                currSum = 0;
        }
        return maxSum;
    }
}