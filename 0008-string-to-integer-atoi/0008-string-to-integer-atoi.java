class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int ans = 0;
        int i = 0;
        int sign = 1;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        if(n == 0){
            return 0;
        }
        while(i<n && s.charAt(i) == ' '){
            i++;
        }
        if(i<n && (s.charAt(i) == '-' || s.charAt(i) == '+')){
            if(s.charAt(i) == '-'){
                sign = -1;
            }
            i++;
        }
        while(i<n && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i)-'0';
            if((ans>max/10) || (ans == max/10 && digit > 7)){
                return sign == -1 ? min: max;
            }
            ans = ans*10+ digit;
            i++;
        }
        return ans*sign;
    }
}