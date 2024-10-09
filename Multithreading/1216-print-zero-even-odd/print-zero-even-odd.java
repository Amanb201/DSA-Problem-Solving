class ZeroEvenOdd {
    private int n;
    private Boolean isZeroProduced = false; //Zero as Producer and even&odd as consumer 
                                            //[i.e. 1 producer, 2 consumer]
    private Boolean isEvenTurn = false;//To ensure execution of odd and even in alternate fashion.
    private int count = 0;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<=n; i++){
            synchronized(this){
                while(isZeroProduced){
                    wait();
                }

                if(count<2*n){
                    printNumber.accept(0);
                    count++;
                    isZeroProduced = true;
                    notifyAll();
                }
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2; i<=n; i=i+2){
            synchronized(this){
                while(!isZeroProduced || !isEvenTurn){
                    wait();
                }

                if(count<2*n){
                    printNumber.accept(i);
                    count++;
                    isZeroProduced = false;
                    isEvenTurn = false;
                    
                    notifyAll();
                }
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<=n; i=i+2){
            synchronized(this){
                while(!isZeroProduced || isEvenTurn){
                    wait();
                }

                if(count<2*n){
                    printNumber.accept(i);
                    count++;
                    isZeroProduced = false;
                    isEvenTurn = true;

                    notifyAll();
                }
            }
        }
    }
}