class Solution {
    int n,m;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        int ans[][] = image;
        int delRow[] = {-1,0,+1,0};
        int delCol[] = {0,+1,0,-1};
        dfs(image,sr,sc,ans,color,delRow,delCol,initialColor);
        return ans;
    }
    public void dfs(int[][] image, int sr, int sc,int ans[][], int color,int delRow[],int delCol[], int initialColor){
        ans[sr][sc] = color;
        int n = image.length;
        int m = image[0].length;
        for(int i= 0;i<4;i++){
            int nrow = sr+delRow[i];
            int ncol = sc+delCol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
            && image[nrow][ncol] == initialColor && ans[nrow][ncol] != color ){
                dfs(image,nrow,ncol,ans,color,delRow,delCol,initialColor);
            }
        }
    }
}