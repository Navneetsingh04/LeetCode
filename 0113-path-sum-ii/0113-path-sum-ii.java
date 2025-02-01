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
    public void solve(TreeNode root,int targetSum,List<List<Integer>> ans,List<Integer> temp,int sum){
        if(root == null){
            return;
        }
        sum += root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null){
            if(sum == targetSum){
                ans.add(new ArrayList<>(temp));   
            }
        }
        else{
            solve(root.left,targetSum,ans,temp,sum);
            solve(root.right,targetSum,ans,temp,sum);
        }
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int sum = 0;
        solve(root,targetSum,ans,temp,sum);
        return ans;

    }
}