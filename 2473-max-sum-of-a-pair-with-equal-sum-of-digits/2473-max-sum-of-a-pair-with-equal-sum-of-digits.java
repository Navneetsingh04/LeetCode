class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxSum = -1;
        for(int i : nums){
           int digitSum = getSum(i);
            if(map.containsKey(digitSum)){
            maxSum = Math.max(maxSum,map.get(digitSum)+i);
            map.put(digitSum, Math.max(map.get(digitSum),i));
        }
        else{
            map.put(digitSum,i);
            }
        }
        return maxSum;
    }
    public int getSum(int n){
        int sum = 0;
        while(n > 0){
            int digit = n%10;
            sum += digit;
            n /= 10;
        }
        return sum;
    }
}