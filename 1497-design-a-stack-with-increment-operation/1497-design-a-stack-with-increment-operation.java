class CustomStack {
    int size;
    int arr[];
    int top;
    public CustomStack(int maxSize) {
        size = maxSize;
        arr = new int[maxSize];
        top = -1;
    }
    
    public void push(int x) {
        if(top == size-1){
            return;
        }
        top++;
        arr[top] = x;
    }
    
    public int pop() {
        if(top == -1){
            return -1;
        }
        int result = arr[top];
        top--;
        return result;
        
    }
    
    public void increment(int k, int val) {
        if(top == -1){
            return;
        }
        int limit = Math.min(k,top+1);
        for(int i = 0; i<limit;i++){
            arr[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */