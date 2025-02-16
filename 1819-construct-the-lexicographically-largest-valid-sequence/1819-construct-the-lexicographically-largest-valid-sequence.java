class Solution {
    public boolean backtrack(int i,int n,int ans[],boolean use[]){
        if(i >= ans.length){
            return true;
        }
        if(ans[i] != -1){
            return backtrack(i+1,n,ans,use);
        }
        for(int num = n;num>0;num--){
            if(use[num]){
                continue;
            }
            use[num] = true;
            ans[i] = num;

            if(num == 1){
                if(backtrack(i+1,n,ans,use)){
                    return true;
                }
            } 
            else{
                int j = i+ans[i];
                if(j < ans.length && ans[j] == -1){
                    ans[j] = num;
                    if(backtrack(i+1,n,ans,use)){
                        return true;
                    }
                    ans[j] = -1;
                }
            }
            use[num] = false;
            ans[i] = -1;
        }
        return false;
    }
    public int[] constructDistancedSequence(int n) {
        int ans[] = new int[2*n-1];
        Arrays.fill(ans,-1);
        boolean use[] = new boolean[n+1];

        backtrack(0,n,ans,use);
        return ans;
    }
}