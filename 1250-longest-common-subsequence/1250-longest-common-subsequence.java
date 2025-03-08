class Solution {
    public int solve(int index1,int index2,String s1, String s2,int dp[][]){
        if(index1 < 0 || index2 <0){
            return 0;
        }
        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }
        if(s1.charAt(index1) == s2.charAt(index2)){
            return 1+solve(index1-1,index2-1,s1,s2,dp);
        }
        dp[index1][index2] =  0+Math.max(solve(index1-1,index2,s1,s2,dp),solve(index1,index2-1,s1,s2,dp));
        return dp[index1][index2];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n+1][m+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return solve(n-1,m-1,text1,text2,dp);
    }
}