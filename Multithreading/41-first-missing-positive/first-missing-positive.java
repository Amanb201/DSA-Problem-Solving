class Solution {
    private void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    public int firstMissingPositive(int[] nums) {
        int size = nums.length;
        
        //Place each item in it's correct position. i.e. 1 --> 0th index
        for(int i=0; i<size; i++){
            int item = nums[i];

            if(item>=1 && item<=size){
                int pos = item-1;

                if(nums[pos] != item){
                    swap(nums, i, pos);
                    i--;
                }
            }
        }

        //finding the first position where correct item is not present
        for(int i=0; i<size; i++){
            if(nums[i] != i+1)
                return i+1;
        }
        return size+1;
    }
}