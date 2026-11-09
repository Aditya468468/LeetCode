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
class Solution 
{
    public int check(TreeNode node)
    {
        if(node==null) return 0;

        int left=check(node.left);
        int right=check(node.right);
        if(left==-1) return -1;
        if(right==-1) return -1; // If any side gives -1, we return it 
        if(Math.abs(left-right)>1) return -1; // we check the ht diff
 
        return 1+Math.max(left,right); // And we return the ht of tree we got 
    }
    public boolean isBalanced(TreeNode root) 
    {

        if(root==null) return true;
        if(check(root)==-1) return false;

        return true;

        
        
    }
}