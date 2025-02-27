class Solution {
    public int solve(int j,int k,int arr[],Map<Integer,Integer> map){
        int target = arr[k] - arr[j];
        if(target >= arr[j] || !map.containsKey(target)){
            return 2;
        }
        int i = map.get(target);
        return 1+solve(i,j,arr,map);
    }
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            map.put(arr[i],i);
        }
        int maxLen = 0;
        for(int j = 1;j<n;j++){
            for(int k = j;k<n;k++){
                int len = solve(j,k,arr,map);
                if(len >= 3){
                    maxLen = Math.max(maxLen,len);
                }
            }
        }
        return maxLen;
    }
}