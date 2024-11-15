class Solution {
/** BRUTE FORCE -O(N^3)
    private boolean isNonDecreasingSequence(int[] arr, int low, int high){
        //To check prev doesn't exist default value is -1
        int prev = -1; 
        for(int i=0; i<arr.length; i++){
            if(i>=low && i<=high){
                continue;
            }
            else{
                if(prev != -1 && arr[i]<prev){
                    return false;
                }
                prev=arr[i];
            }
        }
        return true;
    }

    private boolean isSequenceStrictlyDecreasing(int[] arr){
        for(int i=1; i<arr.length; i++){
            if(arr[i]>=arr[i-1])
                return false;
        }
        return true;
    }

    public int findLengthOfShortestSubarray(int[] arr) {
        int size = arr.length;
        if(isNonDecreasingSequence(arr, -1, -1))
            return 0;

        if(isSequenceStrictlyDecreasing(arr))
            return size - 1;
        
        int mimSubarrayLenToMakeNonDecreasingSeq = size-1;
        for(int i=0; i<size; i++){
            for(int j=i; j<size; j++){
                // System.out.println("i=" + i + " j=" + j);
                if(isNonDecreasingSequence(arr, i, j)){
                    mimSubarrayLenToMakeNonDecreasingSeq = 
                        Math.min(mimSubarrayLenToMakeNonDecreasingSeq, j-i+1);
                }
                // if(mimSubarrayLenToMakeNonDecreasingSeq==0)
                //     System.out.println("i=" + i + " j=" + j);
            }
        }

        return mimSubarrayLenToMakeNonDecreasingSeq;
    }
*/
    public int findLengthOfShortestSubarray(int[] arr) {
        int size = arr.length;
        /**Breaking the main array into two non decreasing sorted array one containing index=0(front) and
        other containing index=size-1 (rear) */
        List<Integer> maxNonDecreasingSubArrayFront = new ArrayList<>();
        List<Integer> maxNonDecreasingSubArrayRear = new ArrayList<>();

        maxNonDecreasingSubArrayFront.add(0);
        for(int i=1; i<size; i++){
            int prev = arr[maxNonDecreasingSubArrayFront.get(i-1)];
            if(arr[i]>=prev){
                maxNonDecreasingSubArrayFront.add(i);
            }
            else
                break;
        }

        if(maxNonDecreasingSubArrayFront.size() == size)
            return 0; //When entire array is already sorted in Non Decreasing Order, so no need to remove any subarray


        maxNonDecreasingSubArrayRear.add(size-1);
        int index=0;
        for(int i=size-2; i>=0; i--){
            int prev = arr[maxNonDecreasingSubArrayRear.get(index)];
            if(arr[i]<=prev){
                maxNonDecreasingSubArrayRear.add(i);
                index++;
            }
            else
                break;
        }

        // if(maxNonDecreasingSubArrayFront.size() == 1 && maxNonDecreasingSubArrayRear.size() ==1)
        //     return size-1; //When only single element can be considered sorted, in this case size-1
        //     //elements need to be removed either from front or 

        List<Integer> reverseMaxNonDecSubarrayRear = new ArrayList<>();
        for(int i=maxNonDecreasingSubArrayRear.size()-1; i>=0; i--){
            reverseMaxNonDecSubarrayRear.add(maxNonDecreasingSubArrayRear.get(i));
        }

        maxNonDecreasingSubArrayRear = new ArrayList<>(reverseMaxNonDecSubarrayRear);

        int maxNonDecreasingSubArrayLength = 
                    maxNonDecreasingSubArrayFront.size()>maxNonDecreasingSubArrayRear.size()    ?
                            maxNonDecreasingSubArrayFront.size() : maxNonDecreasingSubArrayRear.size();

        int left=maxNonDecreasingSubArrayFront.size()-1;
        int right=0;

        while(left>=0 && right<maxNonDecreasingSubArrayRear.size()){
            int rightNum = arr[maxNonDecreasingSubArrayRear.get(right)];
            int leftNum = arr[maxNonDecreasingSubArrayFront.get(left)];
            if(leftNum<=rightNum){
                //So Left and Right subarray can be merged and this can give sorted Array (Non Descending)
                int leftSize = left+1;
                int rightSize = maxNonDecreasingSubArrayRear.size() - right;
                maxNonDecreasingSubArrayLength = Math.max(maxNonDecreasingSubArrayLength, leftSize+rightSize);
                left--; right=0;
            }else{
                if(right == maxNonDecreasingSubArrayRear.size()-1){
                    right = 0;
                    left--;
                }else{
                    right++;
                }
            }
        }
        return size - maxNonDecreasingSubArrayLength;
    }
}