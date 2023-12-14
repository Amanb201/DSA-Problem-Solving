class Solution {
    /**
        Time Complexity: O(Log N) + O(Log N) for finding start and last target element.
        Space Complexity: O(1)
    */
    public int findStartPosition(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = (low+high)/2;
            
            if(low == high && nums[low] != target)
                return -1;
            if(nums[low] == target ){
                return low;
            }
            else if(nums[mid] == target){
                high = mid;
            }
            else if(nums[high] == target){
                if(high-1 >= 0 && nums[high-1]!=target)
                    return high;
                low = mid;
            }
            else if(nums[low] < target && nums[mid] > target){
                //Higher than low and smaller than mid
                high = mid;
            }
            else if(nums[high] > target && nums[mid] < target){
                //Lower than high but greater mid

                if(low == mid)//For the case element not present
                    return -1;

                low = mid;
            }
        }
        return -1;
    }

    public int findLastPosition(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = (low+high)/2;
            
            if(low == high && nums[low] != target)
                return -1;
            if(nums[high] == target){
                return high;
            }
            else if(nums[mid] == target){
                if(low == mid)   //For the case when low and high are consecutives and low 
                    return low; //contains the last target
                low = mid;
            }
            else if(nums[low] == target){
                high = mid;
            }
            else if(nums[low] < target && nums[mid] > target){
                //Higher than low and smaller than mid
                high = mid;
            }
            else if(nums[high] > target && nums[mid] < target){
                //Lower than high but greater mid

                if(low == mid)//For the case element not present
                    return -1;
                    
                low = mid;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] positions = {-1, -1};

        if(nums.length == 0 || 
            (nums.length>0 && (nums[0]>target || nums[nums.length-1]<target)))
            return positions;

        positions[0] = findStartPosition(nums, target);
        positions[1] = findLastPosition(nums, target);
        return positions;
    }
}