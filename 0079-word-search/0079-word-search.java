class Solution {
    int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    int n,m;
    public boolean find(char[][] board,int i ,int j,int index,String word){
        if(index == word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=n || j>=m || board[i][j] == '#'){
            return false;
        }
        if(board[i][j] != word.charAt(index)){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';

        for(int d[] : dir){
            int newI = i+d[0];
            int newJ = j+d[1];

            if(find(board,newI,newJ,index+1,word)){
                return true;
            }
        }
        board[i][j] = temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j] == word.charAt(0) && find(board,i,j,0,word)){
                    return true;
                }
            }
        }
        return false;
    }
}