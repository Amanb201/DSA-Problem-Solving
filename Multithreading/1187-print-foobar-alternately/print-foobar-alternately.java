class FooBar {
    private int n;

    private boolean isItemProduced = false;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
            synchronized(this){
                while(isItemProduced){
                    wait();
                }
            	printFoo.run();
                isItemProduced = true;
                notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
            synchronized(this){
                while(!isItemProduced){
                    wait();
                }
            	printBar.run(); 
                isItemProduced = false;  
                notifyAll();         
            }
        }
    }
}