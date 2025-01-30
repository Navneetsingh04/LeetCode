class Solution {
    public int calculate(String s) {
        // to stroe ans ans signs
        Stack<Integer> st = new Stack<>();
        int sign = 1;
        int ans = 0;
        int n = s.length();
        // Itrating each charcater of string s
        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int number = 0;
                // building number till we encounter a nonDigit
                while(i< n && Character.isDigit(s.charAt(i))){
                    number = number*10+s.charAt(i)-'0';
                    i++;
                }
                // upadting ans with current sign and number
                ans += sign*number;
                // take pointer to the end of number
                i--;
            }
            else if(ch == '+'){
                sign = 1;
            }
            else if(ch == '-'){
                sign = -1;
            }
            else if(ch == '('){
                // push ans and sign on the stack before the parenthesis
                st.push(ans);
                st.push(sign);
                // Reseting ans and sign for the expression inside the parenthesis
                ans = 0;
                sign = 1;
            }
            else if(ch == ')'){
                ans = st.pop()*ans+st.pop();
            }
        }
        return ans;
    }
}