class Solution {
    //Overall
    //Time Complexity O(N Log N)
    //Space Complexity O(N)
    public void mergeAlgo(int[] nums, int low, int mid, int high){
        //Time Complexity O(N)
        //Space Complexity O(N)
        int[] helperArr = new int[high-low+1];
        int index = 0, left = low, right = mid+1;

        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                helperArr[index++] = nums[left];
                left++ ;
            }
            else{
                helperArr[index++] = nums[right];
                right++;
            }
        }
        while(left<=mid){
            helperArr[index++] = nums[left];
            left++;
        }
        while(right<=high){
            helperArr[index++] = nums[right];
            right++;
        }

        index = low;
        for(int i=0; i<helperArr.length; i++){
            nums[index++] = helperArr[i];
        }
    }

    public int countReversePairs(int[] nums, int low, int mid, int high){
        //Time Complexity O(N)
        //Space Complexity O(1)
        int left = low, right = mid+1;
        int count = 0, currCount=0;
        while(left<=mid && right<=high){
            //To Do --- Handle Integer Overflow and Underflow//
            if(nums[left] > 2*(long)nums[right]){
                right++;
            }
            else{
                count += right-(mid+1);
                left++;
            }
        }
        while(left<=mid){
            count += high - (mid+1) +1;
            left++;
        }
        // for(left=left ;left<=mid; left++ ){
            
        //     while(right<=high && nums[right]<Integer.MAX_VALUE/2 && nums[left]>2*nums[right]) {
        //         // System.out.println("Right");
        //         right++;
        //         currCount++;
        //     }
        //     count += currCount;
        // }
        return count;
    }

    public int mergeSort(int[] nums, int low, int high){
        //Time Complexity O(Log N)
        //Space Complexity O(Log N) //Stack Space
        if(low>=high)
            return 0;

        int count=0;
        int mid = (low+high)/2;

        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid+1, high);
        count += countReversePairs(nums, low, mid, high);
        System.out.println("low "+low);
        System.out.println(" high "+high);
        System.out.println(" count "+count);
        mergeAlgo(nums, low, mid, high);

        return count;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
}