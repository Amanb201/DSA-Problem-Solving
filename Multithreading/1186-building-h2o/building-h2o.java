class H2O {

    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    private int oxygenCount = 0;
    private int hydrogenCount = 0;
    public H2O() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		
        lock.lock();

        try {
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            while(hydrogenCount >= 2){
                condition.await();
            }

            releaseHydrogen.run();
            hydrogenCount++;

            if(hydrogenCount==2 && oxygenCount==1){
                //Water molecule has been produced
                hydrogenCount=0;
                oxygenCount=0;
                condition.signalAll();
            }
        }
        finally {
            lock.unlock();
        }    
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.lock();

        try{
            while(oxygenCount >=1){
                condition.await();
            }
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            oxygenCount++;

            if(hydrogenCount==2 && oxygenCount==1){
                //Water molecule has been produced
                hydrogenCount=0;
                oxygenCount=0;
                condition.signalAll();
            }

        }
        finally{
            lock.unlock();
        }
    }
}