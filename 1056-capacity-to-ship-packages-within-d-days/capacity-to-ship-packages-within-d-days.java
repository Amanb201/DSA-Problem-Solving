class Solution {
    /**Tinme Complexity - O(N Log N) */
    public int findDaysforGivenShipCapacity(int[] weights, int capacity){

        int days = 1;
        int load = 0;
        for(int wt=0; wt<weights.length; wt++){//O(N)
            if((load + weights[wt]) < capacity){    
                load += weights[wt];
            }
            else if((load + weights[wt]) == capacity){
                if(wt == weights.length - 1)
                    break;
                load = 0;
                days++;
            }
            else{
                days++;
                load = weights[wt];
            }
        }
        return days;
    }

    public int minShipCapacity(int[] weights, int minCap, int maxCap, int days){
        int left = minCap, right=maxCap;

        int daysNeeded = maxCap;
        while(left<right){//O(Log N) * O(N)
            int mid = (left+right)/2;
            int capacity = mid;
            if(right == left)
                return right;

            daysNeeded = findDaysforGivenShipCapacity(weights, capacity);//O(N)
            System.out.println("capacity"+capacity);
            System.out.println("days"+daysNeeded);
            if(daysNeeded <= days){
                if(mid == left)
                    return left;
                right = mid;
            }
            else if(daysNeeded > days){
                if(mid == left)
                    return right;
                left = mid;
            }
        }
        return right;
    }

    public int shipWithinDays(int[] weights, int days) {
        int len = weights.length;
        int maxWeight = 0;
        int totalWeight = 0;

        for(int index=0; index<len; index++){ //O(N)
            totalWeight += weights[index];

            maxWeight = maxWeight<weights[index] ? weights[index] : maxWeight;
        }

        return minShipCapacity(weights, maxWeight, totalWeight, days);
    }
}