class Solution {
    int expand(String s,int i,int j){
        int count = 0;
        while(i >= 0 && j<s.length() && s.charAt(i) == s.charAt(j)){
            count++;
            i--;
            j++;
        }
        return count;
    }
    public int countSubstrings(String s) {
        int totalCount = 0;
        for(int center = 0;center<s.length();center++){
            // Odd
            int oddAns = expand(s,center,center);
            // even
            int evenAns = expand(s,center,center+1);
            totalCount += oddAns+evenAns;
        }
        return totalCount;
    }
}