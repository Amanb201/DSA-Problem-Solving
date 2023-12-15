class Solution {
    public int findPeakElement(int[] nums) {
        /**
        Time Complexity = O(Log N) //Binary Search
        Space Complexity = O(1)
        
        Intuition - There will be atleast one peak.
        find mid and try to find which side a Peak must be present.
        Whichever side's neighbour is greater than mid will must have atleast one pick in worst
        case. Other side may or may not have any peak.
         */
        if(nums.length == 1)
            return 0;
        if(nums[0] > nums[1])
            return 0;
        if(nums[nums.length-1] > nums[nums.length-2])
            return nums.length-1;

        int low=0, high=nums.length-1;

        while(low<high){
            int mid = (low+high)/2;

            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }
            else if(nums[mid]>nums[mid-1])
                low = mid;
            else if(nums[mid]>nums[mid+1])
                high = mid;
            else //if both neighbour is greater than mid than peak can exist on either side.
                high = mid;
        }
        return 0;
    }
}