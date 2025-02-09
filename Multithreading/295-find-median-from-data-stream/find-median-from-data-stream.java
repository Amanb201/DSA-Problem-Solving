class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b)->b-a);
    }
    
    //1 2   4 5   3
    //
    /**
        maxH=[1] minH =[], 
        maxH=[1] minH = [2]
        maxH=[1] minH = [2,3]
        maxH=[1, 2] minH = [3, 4]
        maxH[1, 2]  minH = [3, 4, 5]
     */
    public void addNum(int num) {
        //Insertion into heap
        if(maxHeap.size()==0){
            maxHeap.add(num);
        }else if(maxHeap.peek()>=num){
            maxHeap.add(num);
        }
        else{
            minHeap.add(num);
        }

        //Balancing Both heaps
        if(maxHeap.size()>minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }
        else if(maxHeap.size()<minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        return minHeap.size() == maxHeap.size()? ((double) minHeap.peek() + (double) maxHeap.peek())/2 : maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */