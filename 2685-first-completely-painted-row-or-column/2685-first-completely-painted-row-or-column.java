class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        int minIndex = Integer.MAX_VALUE;

        for(int i = 0;i<n;i++){
            int lastIndex = Integer.MIN_VALUE;
            for(int j = 0;j<m;j++){
                int val =mat[i][j];
                int idx = map.get(val);
                lastIndex = Math.max(lastIndex,idx);
            }
            minIndex = Math.min(minIndex,lastIndex);
        }
        for(int col = 0;col<m;col++){
            int lastIndex = Integer.MIN_VALUE;
            for(int row= 0;row<n;row++){
                int val = mat[row][col];
                int idx = map.get(val);
                lastIndex = Math.max(lastIndex,idx);
            }
            minIndex = Math.min(minIndex,lastIndex);
        }
        return minIndex;
    }
}