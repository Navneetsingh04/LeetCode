class Solution {
    boolean checkPalindrome(String s,int i ,int j){
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            else{
                i++;
                j--;
            }
        }
        return true;
    } 
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else{
                boolean ans1 = checkPalindrome(s,i+1,j);
                boolean ans2 = checkPalindrome(s,i,j-1);
                return ans1 || ans2;
            }
        }
        return true;
    }
}