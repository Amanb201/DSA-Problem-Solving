class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    Integer top;

    public MyStack() {
        this.queue1 = new LinkedList<Integer>();
        this.queue2 = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        this.queue1.add(x);
        top = x;
    }
    
    public int pop() {
        // System.out.println("POP SIZE");
        // System.out.println(this.queue1.size());
        int item = -1;
        while(!this.queue1.isEmpty()){
            item = this.queue1.poll();
            // System.out.println("POP iter");
            // System.out.println(item);
            if(!this.queue1.isEmpty())
                this.queue2.add(item);
        }

        while(!this.queue2.isEmpty()){
            top = this.queue2.poll();
            this.queue1.add(top);
        }
        // System.out.println("POP");
        // System.out.println(item);
        return item;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
       return this.queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */