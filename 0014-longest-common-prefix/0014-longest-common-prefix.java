class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        int i = 0;
        
        while(i<strs[0].length()){
            char currCh = strs[0].charAt(i);
            for(String str : strs){
                if(i>= str.length() || str.charAt(i) != currCh){
                    return ans.toString();
                }
            }
            ans.append(currCh);
            i++;
        }
        return ans.toString();
    }
}