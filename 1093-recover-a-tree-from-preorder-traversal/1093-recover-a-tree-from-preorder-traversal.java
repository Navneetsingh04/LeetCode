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
    int i = 0;
    int n;
    public TreeNode solve(String s,int depth){
        if(i >= n) return null;
        int dashCount = 0;
        while(i < n && s.charAt(i) == '-'){
            dashCount++;
            i++;
        }
        if(dashCount != depth){
            i -= dashCount;
            return null;
        }
        int num = 0;
        while(i<n && Character.isDigit(s.charAt(i))){
            num = (num*10) +(s.charAt(i)-'0');
            i++;
        }
        TreeNode root = new TreeNode(num);
        root.left = solve(s,depth+1);
        root.right = solve(s,depth+1);

        return root;
    }
    public TreeNode recoverFromPreorder(String traversal) {
        n = traversal.length();
        return solve(traversal,0);

    }
}