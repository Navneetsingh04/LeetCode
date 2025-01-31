class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        // Initialize the stack with -1 to handle the base case for valid substrings starting from the beginning
        st.push(-1);
        int maxLen = 0;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(i);
            }
            else{
                st.pop();
                // If the stack is empty after popping, push the current index onto the stack
                // This handles the case where we have more closing brackets than opening ones
                if(st.isEmpty()){
                st.push(i);
            }
            else{
                int len = i-st.peek();
                maxLen = Math.max(len,maxLen);
                }
            }
        }
        return maxLen;
    }
}