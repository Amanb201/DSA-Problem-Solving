class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergedArr = new int[m+n];

        int index1=0, index2=0;
        int mIndex=0;
        while(index1<m && index2<n){
            if(nums1[index1]<nums2[index2]){
                mergedArr[mIndex++] = nums1[index1++];
            }
            else if(nums1[index1]>nums2[index2]){
                mergedArr[mIndex++] = nums2[index2++];
            }
            else{
                mergedArr[mIndex++] = nums1[index1++];
                mergedArr[mIndex++] = nums2[index2++];
            }
        }

        while(index1<m){
                mergedArr[mIndex++] = nums1[index1++];
        }

        while(index2<n){
                mergedArr[mIndex++] = nums2[index2++];
        }

        for(int i=0; i<m+n; i++)
            nums1[i] = mergedArr[i];
    }
}