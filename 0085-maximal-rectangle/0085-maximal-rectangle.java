class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for(int i = 0;i<=n;i++){
            while(!st.isEmpty() && (i == n || heights[st.peek()]>=heights[i])){
                int height = heights[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty()){
                    width = i;
                }
                else{
                    width = i-st.peek()-1;
                }
                maxArea = Math.max(maxArea,width*height);
            }
            st.push(i);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if(row == 0 || col == 0){
            return 0;
        }
        int[] heights = new int[col];
        int maxArea = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } 
                else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }
}