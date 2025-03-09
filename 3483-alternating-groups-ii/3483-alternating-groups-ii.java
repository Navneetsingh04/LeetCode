class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;

        int i = 0,j = 1;
        while(j<n+(k-1)){
            if(colors[j%n] == colors[(j-1)%n]){
                i = j;
                j++;
                continue;
            }
            if(j-i+1 == k){
                count++;
                i++;
            }
            j++;
        }
        return count;
    }
}