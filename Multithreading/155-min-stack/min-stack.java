class MinStack {
    Stack<Item> stack;
    class Item{
        int value;
        int minValue;
        Item (int _value, int _minValue){
            this.value = _value;
            this.minValue = _minValue;
        }
    }

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        int min = val;
        
        if(!stack.isEmpty()){
            min = val<stack.peek().minValue?val:stack.peek().minValue;
        }

        stack.push(new Item(val, min));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        if(stack.isEmpty())
            return -1;

        return stack.peek().value;
    }
    
    public int getMin() {
        if(stack.isEmpty())
            return -1;

        return stack.peek().minValue;
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