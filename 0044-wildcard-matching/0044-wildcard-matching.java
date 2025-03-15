class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean dp[][] = new Boolean[n+1][m+1];
        return solve(n,m,s,p,dp);
    }
    public boolean solve(int i,int j,String s,String p,Boolean dp[][]){
        if(i==0 && j==0) return true;
        if(i>0 && j==0) return false;
        if(i==0 && j>0){
            for(int k = 1;k<=j;k++){
                if(p.charAt(k-1) != '*'){
                    return false;
                }
            }
            return true;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
            return dp[i][j] = solve(i-1,j-1,s,p,dp);
        }
        if(p.charAt(j-1) == '*'){
            return dp[i][j] = solve(i-1,j,s,p,dp) || solve(i,j-1,s,p,dp);
        }
        return dp[i][j] = false;
    }
}