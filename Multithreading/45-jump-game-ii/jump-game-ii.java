class Solution {
    public int jump(int[] nums) {
        /**
        [2  ,3  ,1   ,1  ,4]
         0   1   2    3   4
        0 max= 2
        1 max = 4


        [1, 2  ,3  ,1   ,1  ,4,  2]
         0  1   2    3   4   5   6
        0 max= 1
        1 max = 3
        2 max = 5
        3 max = 5
        4 max = 5
        5 max = 9
        
         */

         /**
         [7   ,0   ,9,   6   ,9   ,6   ,1   ,7   ,9   ,0   ,1   ,2   ,9  ,0   ,3]
          0    1    2    3    4    5    6    7    8    9    10   11   12  13   14
         
          */
        if(nums.length==1)
            return 0;

         int currMax = Integer.MIN_VALUE,  right = 0;
         int jumpCount = 0;

         for(int left=0; left<nums.length-1; left++){
            currMax = Math.max(currMax, nums[left] + left);

            if(currMax>=nums.length-1){
                jumpCount++;
                return jumpCount;
            }

            if(left==right){
                jumpCount++;
                right = currMax;
            }
         }

         return jumpCount;
    }
}