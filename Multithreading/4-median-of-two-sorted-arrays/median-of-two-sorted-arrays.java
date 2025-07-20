class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return approach1(nums1, nums2);
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