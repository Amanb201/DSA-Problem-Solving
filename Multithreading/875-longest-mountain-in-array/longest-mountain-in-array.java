class Solution {
    public int longestMountain(int[] arr) {
        int size = arr.length;

        int[] leftToRight = new int[size];
        int[] rightToLeft = new int[size];

        int currCount = 1;
        leftToRight[0] = 1;
        for(int i=1; i<size; i++){
            if(arr[i] > arr[i-1]){
                currCount++;
                leftToRight[i] = currCount;
            }
            else{
                currCount = 1;
                leftToRight[i] = currCount;
            }
        }

        currCount=1;
        rightToLeft[size-1] = 1;
        for(int i=size-2; i>=0; i--){
            if(arr[i] > arr[i+1]){
                currCount++;
                rightToLeft[i] = currCount;
            }
            else{
                currCount = 1;
                rightToLeft[i] = currCount;
            }
        }

        int maxMountainLen = 0;
        for(int i=1; i<size-1; i++){
            int currMountainLen = 0;

            if(leftToRight[i]>1 && rightToLeft[i]>1)
                currMountainLen = leftToRight[i] + rightToLeft[i] - 1;
            maxMountainLen = Math.max(maxMountainLen, currMountainLen);
        }

        return maxMountainLen;
    }
}