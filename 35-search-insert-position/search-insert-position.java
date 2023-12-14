class Solution {
    public int searchInsert(int[] nums, int target) {
        /**
        Time Comlexity - O(Log N)
        Space Complexity - O(1) */
        int lowIndex = 0;
        int highIndex = nums.length-1;

        if(nums[lowIndex] > target)
                return lowIndex;

        if(nums[highIndex] < target)
                return highIndex+1;

        while(lowIndex <= highIndex){
            int midIndex = (lowIndex + highIndex)/2;
            if(nums[lowIndex] == target)
                return lowIndex;

            if(nums[highIndex] == target)
                return highIndex;

            if(nums[midIndex] == target)
                return midIndex;

            if(midIndex == lowIndex){
                if(target>nums[lowIndex])
                    return highIndex;
                else
                    return lowIndex;
            }

            if(nums[midIndex] > target){
                highIndex = midIndex;
            }
            else if(nums[midIndex] < target){
                lowIndex = midIndex;
            }        
        }
        return 0;
    }
}