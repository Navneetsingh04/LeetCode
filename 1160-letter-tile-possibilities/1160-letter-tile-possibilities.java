class Solution {
    public int numTilePossibilities(String tiles) {
        int count[] = new int[26];
        for(char c : tiles.toCharArray()){
            count[c-'A']++;
        }
        return findSequences(count);
    }
    public int findSequences(int count[]){
        int totalCount = 0;

        for(int i = 0;i<26;i++){
            if(count[i] == 0){
                continue;
            }
            totalCount++;
            count[i]--;
            totalCount += findSequences(count);
            count[i]++;
        }
        return totalCount;
    }
}