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
    public static int solve(TreeNode root,int currSum){
        if(root == null) return 0;
        currSum = currSum*10+root.val;
        if(root.left == null && root.right == null){
            return currSum;
        }
        return solve(root.left,currSum)+solve(root.right,currSum);
    }
    public int sumNumbers(TreeNode root) {
        return solve(root,0);
    }
}