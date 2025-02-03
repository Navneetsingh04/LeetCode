class Solution {
    public char findTheDifference(String s, String t) {
        int n = s.length();
        int m = t.length();
        int ans = 0;
        for(int i = 0;i<n;i++){
            ans ^= s.charAt(i);
        }
        for(int i = 0;i<m;i++){
            ans ^= t.charAt(i);
        }
        return (char)ans;
    }
}