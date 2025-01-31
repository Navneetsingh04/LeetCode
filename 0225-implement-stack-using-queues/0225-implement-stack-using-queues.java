class MyStack {
    Queue<Integer> q = new ArrayDeque<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        q.add(x);
        for(int i = 0;i<q.size()-1;i++){
            int top = q.peek();
            q.poll();
            q.add(top);
        }
    }
    
    public int pop() {
        int temp = q.peek();
        q.poll();
        return temp;
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
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