class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {

        // int num = 0;

        //BRUTE FORCE
        // int minLen = Integer.MAX_VALUE;
        // for(int i=0; i<=high; i++){
        //     num = 0;
        //     for(int j=i; j<=high; j++){
        //         num = num | nums[j];
        //         if(num >= k){
        //             minLen = Math.min(minLen, j-i+1);
        //         }
        //     }
        // }
        // return minLen == Integer.MAX_VALUE ? -1 : minLen;

        /***
            Dry Run -

            nums = [1, 2, 3]        k = 2;

            k = 2 ==> 0010
                1 ==> 0001
                2 ==> 0010
                3 ==> 0011
         */

        int low=0, high=nums.length;
        int index=0;
        int num = 0, minLen = -1;
        int bitArray[] = new int[32];

        if(k==0)
            return 1;

        while(low<high && index<high){
            updateBitArray(bitArray, nums[index], 1);
            num = convertBitsToNumber(bitArray);

            while(num >= k && low<high){
                int mini = index - low + 1;
                if(minLen == -1)
                    minLen = mini;
                else
                    minLen = Math.min(minLen, mini);
                
                updateBitArray(bitArray, nums[low], -1);
                low++;

                num = convertBitsToNumber(bitArray);
            }
            // System.out.println("index="+index+"   num="+num+"   minLen="+minLen);
            index++;
        }

        return minLen;
    }

    private void updateBitArray(int bitArray[], int num, int delta){
        for(int i=0; i<32; i++){
            if(((num>>i) & 1) != 0){
                bitArray[i] += delta;
            }
        }
    }

    private int convertBitsToNumber(int bitArray[]){
        int num = 0;
        for(int i=0; i<32; i++){
            if(bitArray[i] != 0){
                num = num | (1<<i);
            }
        }
        return num;
    }
}