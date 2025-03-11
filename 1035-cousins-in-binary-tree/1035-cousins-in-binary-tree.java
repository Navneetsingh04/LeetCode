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
    TreeNode parentX = null;
    TreeNode parentY = null;
    int levelX = -1,levelY = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        findParentLevel(root,null,x,y,0);
        return (parentX != parentY && levelX == levelY);
    }
    public void findParentLevel(TreeNode root,TreeNode parent,int x,int y,int level){
        if(root == null) return;
        if(root.val == x){
            parentX = parent;
            levelX = level;
        }
        if(root.val == y){
            parentY = parent;
            levelY = level;
        }
        findParentLevel(root.left,root,x,y,level+1);
        findParentLevel(root.right,root,x,y,level+1);
    }
}