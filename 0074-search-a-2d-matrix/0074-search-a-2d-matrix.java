class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int n = row*col;
        int s = 0;
        int e = n-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            int rowIndex = mid/col;
            int colIndex = mid%col;
            int currentNum = matrix[rowIndex][colIndex];
            if(currentNum==target){
                return true;
            }
            else if(currentNum<target){
                s = mid+1;
            }
            else{
                e = mid-1;
            }
        }
        return false;
    }
}