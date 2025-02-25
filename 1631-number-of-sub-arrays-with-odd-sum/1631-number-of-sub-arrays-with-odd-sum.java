class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int MOD = (int)1e9+7;
        int evenCount = 1,oddCount = 0,count = 0,sum = 0;
        for(int i : arr){
            sum += i;
            if(sum%2 == 0){
                count = (count+oddCount)%MOD;
                evenCount++;
            }
            else{
                count = (count+evenCount)%MOD;
                oddCount++;
            }
        }
        return count;
    }
}