class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low=0;
        int high = nums.length-1;

        if(high == 0)
            return nums[high];

        while(low<=high){
            int mid = (low+high)/2;

            if(low==mid && low==0 && nums[0] != nums[1])
                return nums[0];
            
            if(high==low && low==0 && nums[low] != nums[low+1])
                return nums[low];

            if(high==low && low==nums.length-1 && nums[low] != nums[low-1])
                return nums[low];

            if(mid!=0 && mid!=nums.length-1 && nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])
                return nums[mid];    

            if(mid%2 !=0 && nums[mid] == nums[mid-1]){
                //index odd e.g. 3 i.e. total 4 element on the left including current one.
                low = mid+1; 
            }
            else if(mid%2 !=0 && nums[mid] != nums[mid-1]){
                //index odd e.g. 3 i.e. total 4 element on the left including current one.
                high = mid-1;
            }
            else if(mid%2 ==0 && nums[mid] == nums[mid+1]){
                //index even e.g. 4 i.e. total 5 element on the left including current one. So if till now
                //if all elements are appearing twice then this element should be present at next index.
                low = mid+1;
            }
            else if(mid%2 ==0 && nums[mid] != nums[mid+1]){
                high = mid-1;
            }

        }
        return 0;
    }
}