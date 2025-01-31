class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int ast : asteroids){
            boolean destroy = false;
            if(ast > 0){
                st.push(ast);
            }
            else{
                // -Ve
                if(st.isEmpty() || st.peek() < 0 ){
                    st.push(ast);
                }
                else{
                    // collision
                    while(!st.isEmpty() && st.peek()>0){
                        if(Math.abs(ast) == st.peek()){
                            destroy = true;
                            st.pop();
                            break;
                        }
                        else if(Math.abs(ast) > st.peek()){
                            st.pop();
                        }
                        else{
                            destroy = true;
                            break;
                        }
                    }
                    if(!destroy){
                        st.push(ast);
                    }
                }
            }
        }
        int ans[] = new int[st.size()];
        for(int i = st.size()-1;i>=0;i--){
            ans[i] = st.peek();
            st.pop();
        }
        return ans;
    }
}