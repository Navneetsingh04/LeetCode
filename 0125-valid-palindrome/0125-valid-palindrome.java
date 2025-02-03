class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int n = s.length();
        int l = 0;
        int h = n-1;
        while(l<h){
            if( s.charAt(l) != s.charAt(h)){
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
}