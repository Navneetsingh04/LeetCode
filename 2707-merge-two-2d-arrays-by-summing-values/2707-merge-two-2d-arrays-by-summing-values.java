class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0,j= 0;
        List<int[]> mergedArray = new ArrayList<>();
        while(i<n && j<m){
            if(nums1[i][0] == nums2[j][0]){
                mergedArray.add(new int[]{nums1[i][0],nums1[i][1]+nums2[j][1]});
                i++;
                j++;
            }
            else if(nums1[i][0] < nums2[j][0]){
                mergedArray.add(nums1[i]);
                i++;
            }
            else{
                mergedArray.add(nums2[j]);
                j++;
            }
        }
        while(i < n){
            mergedArray.add(nums1[i]);
            i++;
        }
        while(j < m){
            mergedArray.add(nums2[j]);
            j++;
        }
        int ans[][] = new int[mergedArray.size()][2];
        for(int k = 0;k<mergedArray.size();k++){
            ans[k]= mergedArray.get(k);
        }
        return ans;
    }
}