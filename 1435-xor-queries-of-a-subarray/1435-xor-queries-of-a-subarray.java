class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefixXor = new int[n+1];
        for(int i = 0;i<n;i++){
            prefixXor[i+1] = prefixXor[i]^arr[i];
        }
        int ans[] = new int[queries.length];
        for(int i = 0;i<queries.length;i++){
            ans[i] = prefixXor[queries[i][1]+1]^prefixXor[queries[i][0]];
        }
        return ans;
    }
}