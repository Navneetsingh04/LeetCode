class Solution {
    public int minSwaps(String s) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == ']'){
               count++;
               max = Math.max(count,max);
            }
            else{
                count--;
            }
        }
        return (max+1)/2;
    }
}