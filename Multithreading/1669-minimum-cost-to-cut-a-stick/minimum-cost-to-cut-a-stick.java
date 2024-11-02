class Solution {
    private int partitionDpMinCost(int[] modifiedCuts, int i, int j, int[][] memoizationDpArray){
        if(j-i <= 1) return 0;

        if(memoizationDpArray[i][j] != -1)
            return memoizationDpArray[i][j];

        int minCost = Integer.MAX_VALUE;
        for(int k=i+1; k<j; k++){
            int currCost = (modifiedCuts[j] - modifiedCuts[i]) +
                                                     partitionDpMinCost(modifiedCuts, i, k, memoizationDpArray) +
                                                                partitionDpMinCost(modifiedCuts, k, j, memoizationDpArray);
            minCost = Math.min(currCost, minCost);
        }
        return memoizationDpArray[i][j] = minCost;
    }
    public int minCost(int n, int[] cuts) {
        int[] modifiedCuts = new int[cuts.length+2];

        Arrays.sort(cuts);
        int size = modifiedCuts.length;
        //Appending lower and higher bound for the partition in the given array
        modifiedCuts[0] = 0;
        modifiedCuts[size-1] = n;

        for(int i=1; i<size-1; i++)
            modifiedCuts[i] = cuts[i-1];

        int[][] memoizationDpArray = new int[size][size];
        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++)
                memoizationDpArray[i][j] = -1; 
        
        return partitionDpMinCost(modifiedCuts, 0, size-1, memoizationDpArray);
    }
}