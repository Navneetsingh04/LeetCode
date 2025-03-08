class Solution {
    public int minimumRecolors(String blocks, int k) {
        int left = 0;
        int white = 0;
        int colors = Integer.MAX_VALUE;

        for(int i = 0;i<blocks.length();i++){
            if(blocks.charAt(i) == 'W'){
                white++;
            }
            if(i-left+1 == k){
                colors = Math.min(colors,white);
                if(blocks.charAt(left) == 'W'){
                    white--;
                }
                left++;
            }
        }
        return colors;
    }
}