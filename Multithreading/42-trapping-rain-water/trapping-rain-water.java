class Solution {
    public int trap(int[] height) {
        int size = height.length;
        int[] leftToRight = new int[size];
        int[] rightToLeft = new int[size];

        int maxLeft = height[0];
        leftToRight[0] = maxLeft;;
        for(int i=1; i<size; i++){
            maxLeft = Math.max(maxLeft, height[i]);
            leftToRight[i] = maxLeft;
        }

        int maxRight = height[size-1];
        rightToLeft[size-1] = maxRight;
        for(int i=size-2; i>=0; i--){
            maxRight = Math.max(maxRight, height[i]);
            rightToLeft[i] = maxRight;
        }

        int maxRainWater = 0;
        for(int i=0; i<size; i++){
            maxRainWater += Math.min(leftToRight[i], rightToLeft[i]) - height[i];
        }
        return maxRainWater;
    }
}