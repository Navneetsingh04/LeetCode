class Solution {
    private int ans = 0;
    public void countArragementHelpher(int arr[],int n,int currNum){
        if(currNum == n+1){
            ans++;
            return;
        }
        for(int i = 1;i<=n;i++){
            if(arr[i] == 0 && (currNum % i == 0 || i%currNum == 0)){
                arr[i] = currNum;
                countArragementHelpher(arr,n,currNum+1);
                // backtracking
                arr[i] = 0;
            }
        }
    }
    public int countArrangement(int n) {
        int arr[] = new int[n+1];
        ans = 0;
        countArragementHelpher(arr,n,1);
        return ans;
    }
}