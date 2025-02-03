class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder rev = new StringBuilder(s);
        rev.reverse();
        for(int i = 0;i<s.length();i++){
            if(s.substring(0,s.length()-i).equals(rev.substring(i))){
                return rev.substring(0,i)+s;
            }
        }
        return rev.append(s).toString();
    }
}