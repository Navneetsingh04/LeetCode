class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        Map<Character,Integer> set = new HashMap<>();
        for(int i= 0;i<n;i++){
            char ch = s.charAt(i);
            set.put(ch,set.getOrDefault(ch,0)+1);
        }
        int ans = 0;
        boolean oddFreq = false;
        for(int i : set.values()){
            if((i&1) == 0){
                ans += i;
            }
            else{
                ans += i-1;
                oddFreq = true;
            }
        }
        if(oddFreq){
            return ans+1;
        }
        return ans;
    }
}