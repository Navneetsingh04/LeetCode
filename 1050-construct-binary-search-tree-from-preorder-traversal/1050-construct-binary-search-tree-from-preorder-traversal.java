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
    public TreeNode build(int min,int max,int preorder[]){
        if(i >= preorder.length){
            return null;
        }
        TreeNode root = null;
        if(preorder[i] > min && preorder[i] < max){
            root = new TreeNode(preorder[i++]);
            root.left = build(min,root.val,preorder);
            root.right = build(root.val,max,preorder);
        }
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return build(min,max,preorder);
    }
}