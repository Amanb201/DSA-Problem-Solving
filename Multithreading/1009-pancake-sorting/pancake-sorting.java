class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        /***
            3,2,4,1
            PAss-1
            k = 3
            4 ,2, 3, 1

            k =4
            1 3 2 4

            PAss-2
            k=2
            3 1 2 4

            k = 3
            2 1 3 4

            Pass=3
            k=2
            1 2 3 4
        
         */
         List<Integer> ans = new ArrayList<>();
         int lastIndex = arr.length-1;

         while(lastIndex>0){
            int flipIndex = getMaxItemIndex(lastIndex, arr);
            reverseTill(flipIndex, arr);
            ans.add(flipIndex+1);
            reverseTill(lastIndex, arr);
            ans.add(lastIndex+1);
            lastIndex--;
         }
         return ans;
    }

    private int getMaxItemIndex(int end, int[] arr){
        int maxIndex = 0;

        for(int i=0; i<=end; i++){
            maxIndex = arr[i] > arr[maxIndex] ? i : maxIndex; 
        }
        return maxIndex;
    }

    private void reverseTill(int flipIndex, int[] arr){
        int low = 0, high = flipIndex;

        while(low<high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;

            low++; high--;
        }
    }
}