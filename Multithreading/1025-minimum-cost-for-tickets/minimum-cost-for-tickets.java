class Solution {
    private int minimumCost(int[] days, int[] costs, int index, int passAvailable, int[][] memoizationDpArray, int maxDay){
        if(index == days.length)    return 0;

        if(passAvailable >= maxDay) return 0;

        if(memoizationDpArray[index][passAvailable] != -1)
            return memoizationDpArray[index][passAvailable];

        int costAfterBuying = Integer.MAX_VALUE;
        int costAfterSkipping = Integer.MAX_VALUE;

        if(days[index]<= passAvailable){
            costAfterSkipping =  minimumCost(days, costs, index+1, passAvailable, memoizationDpArray, maxDay);
        }
        else{
            
               int currentCost1 = costs[0] + minimumCost(days, costs, index+1, (days[index] + 0), memoizationDpArray, maxDay);
               int currentCost7 = costs[1] + minimumCost(days, costs, index+1, (days[index] + 6), memoizationDpArray, maxDay);
               int currentCost30 = costs[2] + minimumCost(days, costs, index+1, (days[index] + 29),memoizationDpArray, maxDay);
               
                costAfterBuying = Math.min(costAfterBuying,
                                            Math.min(currentCost1,
                                                     Math.min(currentCost7, currentCost30)));     
        }
        return memoizationDpArray[index][passAvailable]= Math.min(costAfterBuying, costAfterSkipping);
    }
    public int mincostTickets(int[] days, int[] costs) {
        int maxDay = 0;
        for(int day: days)
            maxDay = Math.max(day, maxDay);

        int[][] memoizationDpArray = new int[days.length][maxDay+1];
        for(int i=0; i<days.length; i++)
            for(int j=0; j<= maxDay; j++)
                memoizationDpArray[i][j] = -1;

        return minimumCost(days, costs, 0, 0, memoizationDpArray, maxDay);
    }
}