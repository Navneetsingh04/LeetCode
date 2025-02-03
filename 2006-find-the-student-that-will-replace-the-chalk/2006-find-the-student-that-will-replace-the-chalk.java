class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long totalSum = 0;
        for(int i = 0;i<chalk.length;i++){
            totalSum += chalk[i];
        }
        int remaningChalk = (int)(k%totalSum);
        for(int i = 0;i<chalk.length;i++){
            if( remaningChalk < chalk[i]){
                return i;
            }
            remaningChalk -= chalk[i];
        }
        return 0;
    }
}