class Solution {
    public boolean isAnagram(String s, String t) {
        int freqTable[] = new int[256];
        for(int i = 0;i<s.length();i++){
            freqTable[s.charAt(i)]++;
        }
        for(int i = 0;i<t.length();i++){
            freqTable[t.charAt(i)]--;
        }
        for(int i = 0;i<256;i++){
            if(freqTable[i] != 0){
                return false;
            }
        }
        return true;
    }
}