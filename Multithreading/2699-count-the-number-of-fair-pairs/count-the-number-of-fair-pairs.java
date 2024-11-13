class Solution {
    /***
        Lower = 3 Upper = 6
        0 1 4 4 5 7
        (0,4) (0,4) (0,5)
        (1,5) (1,4) (1,4)
     */

     /**
        Dry Run -
        nums =  [1,7,9,2,5]
        lower = 11  upper = 11

        Step-1 Sorting
        nums = [1, 2, 5, 7, 9]

        low = 0, high=1

        low=0, high=1
      */
    public long countFairPairs(int[] nums, int lower, int upper) {
        /**Approach -1 Brute Force (N^2) */
        // int count = 0;
        // for(int i=0; i<nums.length; i++){
        //     for(int j=i+1; j<nums.length; j++)
        //     {   
        //         int currPair = nums[i] + nums[j];
        //         if(lower<= currPair && currPair<=upper)
        //             count++;
        //     }
        // }

        // return count;


        Arrays.sort(nums);
        return lower_bound(nums, upper + 1) - lower_bound(nums, lower);
    }

    
    // Calculate the number of pairs with sum less than `value`.
    private long lower_bound(int[] nums, int value) {
        int left = 0, right = nums.length - 1;
        long result = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            // If sum is less than value, add the size of window to result and move to the
            // next index.
            if (sum < value) {
                result += (right - left);
                left++;
            } else {
                // Otherwise, shift the right pointer backwards, until we get a valid window.
                right--;
            }
        }

        return result;
    }
}