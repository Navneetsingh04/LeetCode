class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        while(i >= 0 || j >= 0 || carry > 0){
            if(i >= 0){
                carry += a.charAt(i)-'0';
                i--;
            }
            if(j >= 0){
                carry += b.charAt(j)-'0';
                j--;
            }
            ans.append(carry%2);
            carry /= 2;
        }
        return ans.reverse().toString();
    }
}