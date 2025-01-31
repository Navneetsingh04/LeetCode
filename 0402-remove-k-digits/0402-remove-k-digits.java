class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k){
            return "0";
        }
        Stack<Character> st = new Stack<>();
        for(char digit : num.toCharArray()){
            while(k>0 && !st.isEmpty() && st.peek()> digit){
                    st.pop();
                    k--;
                }
                st.push(digit);
            }
            while(k>0){
                st.pop();
                k--;
            }
            StringBuilder ans  = new StringBuilder();
            while(!st.isEmpty()){
                ans.append(st.peek());
                st.pop();
            }
            ans.reverse();
            while(ans.length() > 0 && ans.charAt(0) == '0'){
                ans.deleteCharAt(0);
            }
        return ans.length() == 0 ? "0" : ans.toString();
    }
}