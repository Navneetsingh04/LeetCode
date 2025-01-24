class Solution {
    public boolean isSafe(int row,int col,char[][] board,List<List<String>> ans,int n){
        int dupRow = row;
        int dupCol = col;

        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row--;
            col--;
        }
        col = dupCol;
        row = dupRow;
        while(col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            col--;
        }
        row = dupRow;
        col = dupCol;

        while(row<n && col >=0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row++;
            col--;
        }
        return true;
    }
    public void solve(int col,char[][] board,List<List<String>> ans,int leftRow[],int lowerDiagonal[],int upperDiagonal[],int n){
        if(col == n){
            ans.add(construct(board));
            return;
        }
        for(int row = 0;row<n;row++){
            if(leftRow[row] == 0 && lowerDiagonal[row+col] == 0 && upperDiagonal[n-1+col-row] == 0){
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row+col] = 1;
                upperDiagonal[n-1+col-row] = 1;
                solve(col+1,board,ans,leftRow,lowerDiagonal,upperDiagonal,n);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row+col] = 0;
                upperDiagonal[n-1+col-row] = 0;
            }
        }
    }
    public List<String> construct(char[][] board){
        List<String> res = new ArrayList<>();
        for(int i = 0;i<board.length;i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char board[][] = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0;j<n;j++){
                board[i][j] = '.';
            }
        }
        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2*n-1];
        int lowerDiagonal[] = new int[2*n-1];
        solve(0,board,ans,leftRow,lowerDiagonal,upperDiagonal,n);
        return ans;
    }
}