class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xor = 0;

        for(int num: nums)
            xor = xor ^ num;

        int max = 1;
        for( int i=1; i<maximumBit; i++)
            max = (max<<1) + 1;

        int ans[] = new int[nums.length];
        int index=0;
        for(int i=nums.length-1; i>=0; i--){
            ans[index] = xor ^ max;
            index++;
            xor = xor ^ nums[i];
        }

        return ans;
    }
}