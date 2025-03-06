class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        long N = (long)n*n;

        long gridSum = 0,gridSqrSum = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                gridSum += grid[i][j];
                gridSqrSum += (long)grid[i][j] * grid[i][j];
            }
        }
        long sum = (N*(N+1))/2;
        long sqrSum = (N*(N+1)*(2*N+1))/6;

        long sqrDiff = gridSqrSum - sqrSum;
        long sumDiff = gridSum - sum;

        int a = (int)((sqrDiff/sumDiff+sumDiff)/2);
        int b = (int)((sqrDiff/sumDiff-sumDiff)/2);

        return new int[]{a,b};
    }
}