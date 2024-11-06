class Solution {
    public boolean canSortArray(int[] nums) {
        int size = nums.length;
        // System.out.println(Integer.bitCount(75));
        // System.out.println(Integer.bitCount(34));
        // System.out.println(Integer.bitCount(30));

        for(int i=0; i<size; i++){
            int minIndex = i;
            for(int j=i+1; j<size; j++){
                if(nums[j]<nums[minIndex]){
                    minIndex = j;
                }
            }
            int low = i, high = minIndex;
            //On Each iteration of i try to place the minimum element at ith index.
            while(high > low){
                //We got the minimum number to be swapped with current i

                //Ensuring whether swap possible between consecutive indices.
                if(Integer.bitCount(nums[high]) != Integer.bitCount(nums[high-1]))
                    return false;
                
                //Swapping
                int temp = nums[high];
                nums[high] = nums[high-1];
                nums[high-1] = temp;

                high--;
            }
        }
        return true;
    }
}