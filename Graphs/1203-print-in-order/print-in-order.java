class Foo {

    private Boolean isFirstRan = false;
    private Boolean isSecondRan = false;
    private Boolean isThirdRan = false; 
    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (this){
            printFirst.run();
            isFirstRan = true;
            notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized (this){
            while(!isFirstRan){
                wait();
            }
            printSecond.run();
            isSecondRan = true;
            isFirstRan = false;
            notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized (this){
            while(!isSecondRan){
                wait();
            }
            printThird.run();
            isSecondRan = false;
        }
    }
}