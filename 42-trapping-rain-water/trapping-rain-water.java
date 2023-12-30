class Solution {
    /**Time Complexity - O(N) for 3 times iterating over Height array
       Space Complexity -O(N) for 2 additonal arrays */
    public int trap(int[] height) {
        int len = height.length;
        int [] left = new int[len];
        int [] right = new int[len];

        int currMax = height[0];
        for(int index=0; index<len; index++){
            left[index] = currMax;
            currMax = currMax<=height[index] ? height[index] : currMax;
        }

        currMax = height[len - 1];
        for(int index=len-1; index>=0; index--){
            right[index] = currMax;
            currMax = currMax<=height[index] ? height[index] : currMax;
        }

        int trapWater = 0;

        for(int index = 0; index<len; index++){
            int waterAtIndex = Math.min(left[index], right[index]) - height[index];
            trapWater += waterAtIndex>0 ? waterAtIndex : 0;
        }

        return trapWater;
    }
}