class Solution {
    /**
    [3,1,3,4,3] k =6
    1 3 3 3 4


     */
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int count = 0;

        int size = nums.length;
        int low =0, high = size-1;

        while(low<high){
            if(nums[low] + nums[high] == k){
                count++;
                low++;
                high--;
                // if(low+1<size && nums[low+1] != nums[low]){
                //     low++;
                // }
                // else{
                //     high--;
                // }
            }
            else if(nums[low] + nums[high] > k){
                high--;
            }
            else{
                low++;
            }
        }
        return count;
    }
}