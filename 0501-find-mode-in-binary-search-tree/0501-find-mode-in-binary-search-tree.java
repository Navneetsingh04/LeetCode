/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int[] findMode(TreeNode root) {
        int maxStreak = 0;
        int currStreak = 0;
        int currNum = 0;
        List<Integer> list = new ArrayList<>();

        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode temp = curr.left;
            while(temp.right != null){
                temp = temp.right;
            }
            temp.right = curr;

            TreeNode left = curr.left;
            curr.left = null;
            curr = left;
            }
              else{
            if(curr.val == currNum){
                currStreak++;
            }
            else{
                currStreak = 1;
                currNum = curr.val;
            }
            if(currStreak > maxStreak){
                list = new ArrayList();
                maxStreak = currStreak;
            }
            if(currStreak == maxStreak){
                list.add(curr.val);
            }
            curr = curr.right;
            }
        }
        int ans[] = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}