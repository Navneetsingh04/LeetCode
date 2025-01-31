class MinStack {
    class Pair{
        int first;
        int second;

        Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    ArrayList<Pair> st;
    public MinStack() {
        st = new ArrayList<>();
    }
    public void push(int val) {
        if(st.isEmpty()){
            st.add(new Pair(val,val));
        }
        else{
            int min = st.get(st.size()-1).second;
            st.add(new Pair(val,Math.min(min,val)));
        }
    }
    public void pop() {
        if(!st.isEmpty()){
            st.remove(st.size()-1);
        }
    }
    
    public int top() {
        if(!st.isEmpty()){
            Pair rightMostPair = st.get(st.size()-1);
            return rightMostPair.first;
        }
        return -1;
    }
    
    public int getMin() {
        if(!st.isEmpty()){
            Pair rightMostPair = st.get(st.size()-1);
            return rightMostPair.second;
        }
        return -1;
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