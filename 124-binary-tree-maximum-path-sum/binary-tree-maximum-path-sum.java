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
    public int maxSum=Integer.MIN_VALUE;

    public int path(TreeNode node)
    {
        if(node==null) return 0;

        int left=Math.max(path(node.left),0);
        int right=Math.max(path(node.right),0);

        maxSum=Math.max(node.val+left+right,maxSum);

        return node.val+Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) 
    {
        path(root);

        return maxSum;
    }
}