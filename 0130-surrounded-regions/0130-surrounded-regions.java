class Solution {
    int n,m;
    public void dfs(int row,int col,boolean vis[][],char board[][],int delRow[],int delCol[]){
        vis[row][col] = true;
        for(int i = 0;i<4;i++){
            int nrow = row+delRow[i];
            int ncol = col+delCol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
            && !vis[nrow][ncol] && board[nrow][ncol] == 'O'){
                dfs(nrow,ncol,vis,board,delRow,delCol);
            }
        }
    }
    public void solve(char board[][]){
        n = board.length;
        m = board[0].length;
        int delRow[] = {-1,0,+1,0};
        int delCol[] = {0,+1,0,-1};
        boolean vis[][] = new boolean[n][m];
        // tarverse 1st row and last row
        for(int j = 0;j<m;j++){
            if(!vis[0][j] && board[0][j] == 'O'){
                dfs(0,j,vis,board,delRow,delCol);
            }
            if(!vis[n-1][j] && board[n-1][j] == 'O'){
                dfs(n-1,j,vis,board,delRow,delCol);
            }
        }
        // tarverse 1st and last column
        for(int i = 0;i<n;i++){
            if(!vis[i][0] && board[i][0] == 'O'){
                dfs(i,0,vis,board,delRow,delCol);
            }
            if(!vis[i][m-1] && board[i][m-1] == 'O'){
                dfs(i,m-1,vis,board,delRow,delCol);
            }
        }
        for(int  i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(!vis[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}