class Solution {
    /**Time Complexity - O(N Log N) 
    Space Complexity - O(1)*/
    public boolean isMiddaysSufficientToPrepareMBouquets(int[] bloomDay, int day, int m ,int k){
        int consFlowersCount = 0, bouquetsCount = 0;
        for(int index=0; index<bloomDay.length; index++){//O(N)
            if(bloomDay[index]<=day){
                consFlowersCount++;
            }
            else{
                bouquetsCount += consFlowersCount/k;
                consFlowersCount = 0;
            }
        }
        bouquetsCount += consFlowersCount/k;
        return (bouquetsCount>=m);
    }

    public int findMinimumDaystoPrepareBouquets(int[] bloomDay, int lowDay, int highDay, int m, int k){
        int minSufficientDays = highDay;
        while(lowDay<=highDay){//O(Log N) * O(N)
            int midDay = (lowDay+highDay)/2;

            boolean isDaysSufficient = isMiddaysSufficientToPrepareMBouquets(bloomDay, midDay, m, k);//O(N)
            
            if(isDaysSufficient){
                minSufficientDays = midDay;
                highDay = midDay-1;
            }
            else{
                lowDay = midDay+1;
            }
        }
        
        return minSufficientDays;
    }
    
    public int minDays(int[] bloomDay, int m, int k) {
        int flowerCount = bloomDay.length;
        if(k > 1000000000/m) return -1; //Overflow condition
        if(flowerCount < m*k)   return -1;

        int maxDaytoBloom = 0, minDaytoBloom=bloomDay[0];
        for(int index=0; index<flowerCount; index++){//O(N)
            maxDaytoBloom = maxDaytoBloom<bloomDay[index] ? bloomDay[index] : maxDaytoBloom;
            minDaytoBloom = minDaytoBloom>bloomDay[index] ? bloomDay[index] : minDaytoBloom;
        }

        return findMinimumDaystoPrepareBouquets(bloomDay, minDaytoBloom, maxDaytoBloom, m, k);
    }
}