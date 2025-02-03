class Solution {
    public long gridGame(int[][] grid) {
        long firstRowRemainSum = 0;
        for(int num : grid[0]){
            firstRowRemainSum += num;
        }
        long secondRowRemainSum = 0;
        long minimizedRobort2Sum = Long.MAX_VALUE;
        for(int R1col = 0;R1col<grid[0].length;R1col++){
            firstRowRemainSum -= grid[0][R1col];

            long bestOfRobort2 = Math.max(firstRowRemainSum,secondRowRemainSum);
            minimizedRobort2Sum = Math.min(minimizedRobort2Sum,bestOfRobort2);
            secondRowRemainSum += grid[1][R1col];
        }
        return minimizedRobort2Sum;
    }
}