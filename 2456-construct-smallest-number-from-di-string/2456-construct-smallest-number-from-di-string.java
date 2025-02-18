class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int count = 1;
        for(int i = 0;i<=n;i++){
            st.push((char)('0'+count++));

            if(i == n || pattern.charAt(i) == 'I'){
                while(!st.isEmpty()){
                    ans.append(st.pop());
                }
            }
        }
        return ans.toString();
    }
}