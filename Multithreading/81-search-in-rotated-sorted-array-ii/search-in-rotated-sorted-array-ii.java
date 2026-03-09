class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length-1;

        while(low <= high){
            int mid = (high - low)/2 + low;

            if(nums[mid] == target) return true;

            //Edge Case Which can Fail due to duplicates.
            //Duplicate element can be present at low/high and Mid then it won't be possible to eliminate
            //one side, we're not sure which portion is sorted and which one is not, so, we should simply
            //cut off those edges where these ambiguity is present
            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                low++; high--;
                continue;
            }


            //Left Portion is sorted
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target < nums[mid]){
                    //Target can be present on Sorted Portion
                    high = mid - 1;
                }
                else{
                    //Target can be present on Unsorted Portion
                    low = mid + 1;
                }
            }
            else{
                //Right Portion is sorted
                if(nums[mid] < target && target <= nums[high]){
                    //Target can be on Sorted portion
                    low = mid + 1;
                }
                else{
                    //Target can be on Unsorted Portion
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}