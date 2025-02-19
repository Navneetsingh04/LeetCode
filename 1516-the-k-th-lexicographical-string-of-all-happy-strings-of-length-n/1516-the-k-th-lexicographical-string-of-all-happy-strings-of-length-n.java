class Solution {
    public String getHappyString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        String ans[] = {""};
        int count[] = {0};
        solve(sb,n,k,count,ans);
        return ans[0];
    }
    public void solve(StringBuilder sb,int n,int k,int count[],String ans[]){
        if(sb.length() == n){
            count[0]++;
            if(count[0] == k){
                ans[0] = sb.toString();
            }
            return;
        }
        for(char ch = 'a';ch<='c';ch++){
            if(sb.length() > 0 && sb.charAt(sb.length()-1) == ch){
                continue;
            }
            sb.append(ch);
            solve(sb,n,k,count,ans);
            if(!ans[0].isEmpty()) return;
            sb.deleteCharAt(sb.length()-1);
        }
    }
}