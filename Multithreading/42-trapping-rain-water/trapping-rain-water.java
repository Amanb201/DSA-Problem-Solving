class Solution {
    public int trap(int[] height) {
        // return prefixPostfixMaxApproach(height);
        return monotonicStackApproach(height);
    }

    // private int monotonicStackApproach(int[] height) {
        
    // }

    private int monotonicStackApproach(int[] height) {
        Stack<Integer> stk = new Stack<>();
        int low = 0, high = height.length;

        int waterTrapped = 0;
        while(low<high){

            //Maintaining Monotonic Stack to find Right Boundary
            while(!stk.isEmpty() && height[low]>height[stk.peek()]){
                int curr = stk.pop();

                //No left boundary available
                if(stk.isEmpty())   break;

                //There can be multiple height in between leftMax and Low(Right Boundary)
                int leftMax = stk.peek();
                int boudedWaterHeight = Math.min(height[leftMax], height[low]) - height[curr];
                int width = low - leftMax - 1;
                waterTrapped += width * boudedWaterHeight;
            }

            stk.push(low++);
        }
        return waterTrapped;
    }

    private int prefixPostfixMaxApproach(int[] height) {
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