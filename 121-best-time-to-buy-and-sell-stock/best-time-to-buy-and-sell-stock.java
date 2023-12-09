class Solution {

    public void findCurrMinForEveryIndex(int[] prices, int size, int[] currMinArray){
        int currMin = prices[0];

        //Finding minimum buy price at every index
        for(int index=0; index<size; index++){
            if(prices[index]<currMin){
                currMinArray[index] = prices[index];
                currMin = prices[index];
            }
            else{
                currMinArray[index] = currMin;
            }
        }
    }

    public void findCurrMaxForEveryIndex(int[] prices, int size, int[] currMaxArray){
        int currMax = prices[size-1];

        /*Finding maximum sell price at every index, should be calculated in reverse 
        order to ensure that we can sell only after we bought it.*/
        for(int index=size-1; index>=0; index--){
            if(prices[index]>currMax){
                currMaxArray[index] = prices[index];
                currMax = prices[index];
            }
            else{
                currMaxArray[index] = currMax;
            }
        }
    }

    public int findMaxProfit(int[] currMinArray, int[] currMaxArray, int size){
        int maxProfit = 0;
        
        //finding which buy and sell combination gives max profit
        for(int index=0; index<size; index++){
            if(currMaxArray[index] - currMinArray[index] > maxProfit)
                maxProfit = currMaxArray[index] - currMinArray[index];
        }
        return maxProfit;
    }

    public int maxProfit(int[] prices) {
        int size = prices.length;
        int[] currMinArray = new int[size];
        int[] currMaxArray = new int[size];

        //Maximum profit can be generated if we buy minimum and sell at maximum price

        //Finding minimum buy price at every index
        findCurrMinForEveryIndex(prices, size, currMinArray);
        
        //Finding maximum sell price at every index
        findCurrMaxForEveryIndex(prices, size, currMaxArray);

        //finding which buy and sell combination gives max profit
        return findMaxProfit(currMinArray, currMaxArray, size);
    }
}