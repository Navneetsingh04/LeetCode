class Solution {
    public int countArrays(int[] original, int[][] bounds) {
        int n = original.length;
        if(n == 0) return 0;
        int low = bounds[0][0];
        int high = bounds[0][1];
        for(int i = 1;i<n;i++){
            int diff = original[i] - original[0];
            int lBound = bounds[i][0]- diff;
            int uBound = bounds[i][1] - diff;

            low = Math.max(low,lBound);
            high = Math.min(high,uBound);
            if(low>high){
                return 0;
            }
        }
        return high-low+1;
    }
}