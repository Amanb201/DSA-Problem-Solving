class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        /**
            Time Complexity - O(NLogN) 
            Space Complexity - O(N)
        */

        //O(NLogN)
        Arrays.sort(trips, (tripA, tripB)->tripA[1]-tripB[1]);

        Queue<int[]> carQueue = new PriorityQueue<>((tripA,tripB)->tripA[2]-tripB[2]);

        int occupied = 0;

        //O(NLogN)
        for(int trip[]: trips){
            int currPickUp = trip[1];
            int currDropOff = trip[2];
            
            while(!carQueue.isEmpty() && carQueue.peek()[2]<=currPickUp){
                int dropPassengers = carQueue.peek()[0];
                occupied -= dropPassengers;
                carQueue.poll();
            }
            
            carQueue.add(trip);
            occupied += trip[0];

            if(occupied>capacity)
                return false;
        }
        return true;
    }
}