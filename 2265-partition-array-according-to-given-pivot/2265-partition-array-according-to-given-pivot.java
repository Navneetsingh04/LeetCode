class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        for(int i : nums){
            if(i<pivot){
                list1.add(i);
            }
            else if(i == pivot){
                list2.add(i);
            }
            else{
                list3.add(i);
            }
        }
        int ans[] = new int[nums.length];
        int index = 0;
        for(int num : list1){
            ans[index++] = num;
        }
        for(int num : list2){
            ans[index++] = num;
        }
        for(int num : list3){
            ans[index++] = num;
        }
        return ans;
    }
}