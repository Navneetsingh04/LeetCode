class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int rows = image.length;
        int cols = image[0].length;
        for(int[] row : image){
            for(int i = 0;i<(cols+1)/2;i++){
                int temp = row[i]^1;
                row[i] = row[cols-i-1]^1 ;
                row[cols-i-1] = temp;
            }
        }
        return image;
    }
}