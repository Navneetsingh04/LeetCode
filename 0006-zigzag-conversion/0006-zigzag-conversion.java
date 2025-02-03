class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || n == numRows) {
            return s;
        }
        char[] ans = new char[n];
        int count = 0;
        for(int i = 0;i<numRows;i++){
            int j = i;
            int k = 0;
            int numChar = 2*(numRows-1);
            while(j<n){
                ans[count++] = s.charAt(j);
                if(i == 0 || ((i+j)%numChar)!= 0){
                    k = 2*(numRows-(i+1));
                }
                else{
                    k = 2*i;
                }
                j = j+k;
            }
        }
        return new String(ans);
    }
}
