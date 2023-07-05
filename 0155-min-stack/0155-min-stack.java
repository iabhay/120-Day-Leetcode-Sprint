class MinStack {
    
   Stack<Long> obj = new Stack<Long>();
    Long min;
    
    public MinStack() {
        min = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        Long value = Long.valueOf(val);
        if(obj.isEmpty()){
            min = value;
            obj.push(value);
        }
        else{
            if(value < min){
                obj.push(2*value - min);
                min = value;
            }
            else{
                obj.push(value);
            }
        }
        
    }
    
    public void pop() {
        if(obj.isEmpty()){
            return;
        }
        Long value = obj.pop();
        if(value < min){
            min = 2* min - value;
        }
    }
    
    public int top() {
        Long value = obj.peek();
        if(value < min){
            return min.intValue();
        }
        else{
             return value.intValue();
        }
       
    }
    
    public int getMin() {
        return min.intValue();
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