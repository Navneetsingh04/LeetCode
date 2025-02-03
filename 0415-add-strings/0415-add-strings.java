class Solution {
      public String addRE(String num1,String num2,int p1,int p2,int carry){
        if(p1 < 0 && p2<0){
            if(carry != 0){
                return String.valueOf((char)(carry+'0'));
            }
            return "";
        }
        int n1 = (p1 >= 0?num1.charAt(p1):'0')-'0';
        int n2 = (p2 >= 0?num2.charAt(p2):'0')-'0';
        int csum = n1+n2+carry;
        int digit  = csum%10;
        carry = csum/10;
        
        String ans = addRE(num1, num2, p1-1, p2-1, carry);
        return ans+(char)(digit+'0');

    }
    public String addStrings(String num1, String num2) {
        int p1 = num1.length()-1;
        int p2 = num2.length()-1;
        return addRE(num1, num2, p1, p2, 0);
    }
}