class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
         List<Integer> ans = new ArrayList<Integer>();
        int row = matrix.length;
        int col = matrix[0].length;
        int total = row*col;

        int startingrow = 0;
        int endingcol = col-1;
        int endingrow = row-1;
        int startingcol = 0;
        int count = 0;
        while(count<total){
            // print Strting row
            for(int i = startingcol;i<=endingcol && count<total;i++){
                ans.add(matrix[startingrow][i]);
                count++;
            }
            startingrow++;
            // print ending column
            for(int i = startingrow;i<=endingrow && count<total;i++){
                ans.add(matrix[i][endingcol]);
                count++;
            }
            endingcol--;
            // print ending row
            for(int i = endingcol;i>=startingcol && count<total;i--){
                ans.add(matrix[endingrow][i]);
                count++;
            }
            endingrow--;
            // printing  starting column
            for(int i = endingrow;i>=startingrow && count<total;i--){
                ans.add(matrix[i][startingcol]);
                count++;
            }
            startingcol++;
        }
        return ans;
    }
}