class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);

        for(int i=0; i<heights.length-1; i++){
            if(heights[i]>=heights[i+1])
                continue;

            int deltaHeight = heights[i+1] - heights[i];
            if(deltaHeight <= bricks){
                //Will use bricks to climb the next building
                bricks = bricks - deltaHeight;
                maxHeap.add(deltaHeight);
            }
            else if(ladders>0){
                //will use ladder to climb the next building
                //If curr delta height is less than the previous max height climbed with bricks
                //Then we should consider climbing that previous building with ladder
                if(!maxHeap.isEmpty() && deltaHeight < maxHeap.peek()){
                    bricks = bricks+maxHeap.poll();
                    
                    //Now use bricks to climb next building
                    bricks -= deltaHeight;
                    maxHeap.add(deltaHeight);
                }
                ladders--;
            }
            else{
                return i;
            }
        }
        return heights.length-1;
    }
}