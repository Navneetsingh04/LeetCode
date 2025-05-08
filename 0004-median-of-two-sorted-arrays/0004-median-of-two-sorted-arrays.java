class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int l = 0,h = 0;
        int arr[] = new int[n+m];
        int index = 0;
        while(l < n && h < m){
            if(nums1[l] < nums2[h]){
                arr[index++] = nums1[l++];
            }
            else{
                arr[index++] = nums2[h++];
            }
        }
        while(l < n){
            arr[index++] = nums1[l++];
        }
        while(h < m){
            arr[index++] = nums2[h++];
        }

        int size = arr.length;
        int mid = size/2;
        if((size&1) == 1){
            return (double)arr[mid];
        }
        return (arr[mid-1]+arr[mid])/2.0;
    }
}