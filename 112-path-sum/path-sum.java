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
    public boolean calculate(TreeNode node,int targetSum,int sum)
    {
        if(node==null) return false; 

        sum+=node.val;

        if(node.left==null && node.right==null)
        {
            return targetSum==sum;
        } //Found the Path to the leaf node, and determined whether sum==target or not.
    
        
        return calculate(node.left,targetSum,sum) || calculate(node.right,targetSum,sum);

    }
    public boolean hasPathSum(TreeNode root, int targetSum) 
    {
        if(root==null) return false;


        return calculate(root,targetSum,0);
    }
}