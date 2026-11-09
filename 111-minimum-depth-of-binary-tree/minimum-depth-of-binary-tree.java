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
    public int find(TreeNode node)
    {
        if(node==null) return 0;
        if(node.right==null)
        {
            return 1+find(node.left);
        }
        if(node.left==null)
        {
            return 1+find(node.right);
        }

        return 1+Math.min(find(node.right),find(node.left));
    }
    public int minDepth(TreeNode root) 
    {
        return find(root);
        
    }
}