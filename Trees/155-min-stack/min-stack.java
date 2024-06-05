class MinStack {
    // 0 - 0
    // 4 - 1
    // 5 - 1
    // 3 - 1
    // 2 - 1
    // 1 - null
    private Stack<Pair<Integer, Integer>> stack;
    public MinStack() {
        stack = new Stack<Pair<Integer, Integer>>();
    }
    
    public void push(int val) {
        if(this.stack.empty()){
            this.stack.push(new Pair<Integer, Integer>(val, val));
        }
        else{
            Pair<Integer, Integer> topElement = this.stack.peek();
            int currMin = val<topElement.getValue() ? val : topElement.getValue();
            this.stack.push(new Pair<>(val, currMin));
        }
    }
    
    public void pop() {
        if(!this.stack.empty()){
            this.stack.pop();
        }
    }
    
    public int top() {
        if(!this.stack.empty()){
            Pair<Integer, Integer> topElement = this.stack.peek();
            return topElement.getKey();
        }
        return Integer.MIN_VALUE;
    }
    
    public int getMin() {
        if(!this.stack.empty()){
            Pair<Integer, Integer> topElement = this.stack.peek();
            return topElement.getValue();
        }
        return Integer.MIN_VALUE;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */