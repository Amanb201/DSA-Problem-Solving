class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // return approach1(nums1, nums2);
        return optimalApproach(nums1, nums2);
    }

    /**
        Binary Search
        Time Complexity - O(Log(N+M))
        Space Complexity - O(1)
     */
    private double optimalApproach (int[] nums1, int[] nums2){
        int arr1[], arr2[];

        if(nums1.length<nums2.length){
            arr1 = nums1; arr2 = nums2;
        }
        else{
            arr1 = nums2; arr2 = nums1;
        }

        int size1 = arr1.length, size2 = arr2.length;
        int leftPartitionSize = (size1 + size2 + 1)/2;

        int low = 0, high = size1;
        while(low<=high){
            int mid1 = (low+high)/2;
            int mid2 = leftPartitionSize - mid1;

            int left1 = mid1-1>=0 ? arr1[mid1-1] : Integer.MIN_VALUE;
            int left2 = mid2-1>=0 ? arr2[mid2-1] : Integer.MIN_VALUE;
            int right1 = mid1<size1 ? arr1[mid1]: Integer.MAX_VALUE;
            int right2 = mid2<size2 ? arr2[mid2]: Integer.MAX_VALUE;

            if(left1 <= right2 && left2 <= right1){
                //Valid Partition

                //Even - Mean(Max from left Partion and Min from Right Partion)
                //Odd - Max from left Partition
                return (size1 + size2) % 2 == 0 ? ((double) Math.max(left1, left2) + Math.min(right1, right2))/2
                                                : (double) Math.max(left1, left2);
            }
            else if(left1 > right2){
                //Move left
                high = mid1-1;
            }
            else if(left2 > right1){
                //Move Right
                low = mid1 + 1;
            }
        }
        return -1;
    }


    /**
        Two Pointer Approach
        Time Complexity - O(N+M)
        Space Complexity - O(1)
     */
    private double approach1 (int[] nums1, int[] nums2){
        int size1= nums1.length;
        int size2 = nums2.length;

        int first=0, second=0;
        int median1=-1, median2=-1;

        for(int i=0; i<=(size1+size2)/2; i++){
            median2 = median1;
            if(first<size1 && second<size2){
                if(nums1[first]<=nums2[second])
                    median1 = nums1[first++];
                else
                    median1 = nums2[second++];
            }
            else if(first < size1){
                median1 = nums1[first++];
            }
            else if(second < size2){
                median1 = nums2[second++];
            }
        }

        return ((size1+size2)%2 == 0) ? ((double) median1 + median2)/2 : median1;
    }
}