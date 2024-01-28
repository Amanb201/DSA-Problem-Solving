class MedianFinder {
    /**Time complexity - For Adding element into queue - O(LogN)
                         For finding median O(1)
                         So, doing this operation for N data items in a stream,
                         overall TC=> O(N LogN) 
        Space Complexity - O(N)*/
    PriorityQueue<Integer> leftPQ;
    PriorityQueue<Integer> rightPQ;

    public MedianFinder() {
        this.leftPQ = new PriorityQueue<Integer>((a,b)->b-a); //MaxHeap
        this.rightPQ = new PriorityQueue<Integer>((a,b)->a-b); //MinHeap
    }
    
    public void addNum(int num) {
        int leftPqSize = this.leftPQ.size();
        int rightPqSize = this.rightPQ.size();
        
        if(leftPqSize == 0){
            this.leftPQ.add(num);
        }
        else{
            if(num <= this.leftPQ.peek()){
                //element should go on left PQ
                if((leftPqSize+rightPqSize)%2 == 0){
                    //Item is already balanced, In the case Odd split, left is getting +1
                    this.leftPQ.add(num);
                }
                else{
                    //To split both the PQs equally moving item from Left to Right
                    this.leftPQ.add(num);

                    int item = this.leftPQ.poll();
                    this.rightPQ.add(item);
                }
            }
            else{
                //element should go on right PQ
                if((leftPqSize+rightPqSize)%2 == 0){
                    this.rightPQ.add(num);

                    int item = this.rightPQ.poll();
                    this.leftPQ.add(item);
                }
                else{
                    this.rightPQ.add(num);
                }
            }
        }
    }
    
    public double findMedian() {
        int leftPqSize = this.leftPQ.size();
        int rightPqSize = this.rightPQ.size();
        
        if((leftPqSize+rightPqSize)%2 != 0){
            return this.leftPQ.peek();
        } 
        else{
            double left = this.leftPQ.peek();
            double right = this.rightPQ.peek();
            return (left+right)/2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */