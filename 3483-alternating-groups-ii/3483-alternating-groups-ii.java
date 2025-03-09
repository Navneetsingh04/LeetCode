class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;
        int N = n+(k-1);

        int[] extendedColors = new int[N];
        for(int i = 0; i < n; i++){
            extendedColors[i] = colors[i];
        }
        for(int i = 0; i < k - 1; i++){
            extendedColors[n + i] = colors[i];
        }
        int i = 0,j = 1;
        while(j<N){
            if(extendedColors[j] == extendedColors[j-1]){
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