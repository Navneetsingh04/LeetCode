class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int ans[] = new int[n];
        for(int i = 0;i<n;i++){
            ans[i] = 0;
        }
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<n;i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                ans[st.peek()] = i-st.peek();
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
}