class Solution {
    public boolean isIsomorphic(String s, String t) {
        int hash[] = new int[256]; //mapping char of s to t
        // store if t[i] char already mapped with s[i]
        boolean istCharMapped[] = new boolean[256];
        for(int i = 0;i<s.length();i++){
            //mapped s[i] with t[i] if s[i] == 0
            if(hash[s.charAt(i)] == 0 && !istCharMapped[t.charAt(i)]){
                hash[s.charAt(i)] = t.charAt(i);
                istCharMapped[t.charAt(i)] = true;
            }
        }
        for(int i = 0;i<s.length();i++){
            if(hash[s.charAt(i)] != t.charAt(i)){
                return false;
            }
        }
        return true;
    }
}