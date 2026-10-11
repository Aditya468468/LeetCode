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
    public boolean check(TreeNode p,TreeNode q)
    {
        if(p==null && q==null) //if both reaches null--> True 
        {
            return true;
        }
        if(p==null || q==null) //If any single Node reaches null--> False
        {
            return false;
        }
        if(p.val!=q.val) return false; // Value Mismatch

        return (check(p.left,q.left) && check(p.right,q.right));
    }
    public boolean isSameTree(TreeNode p, TreeNode q) 
    {
        return check(p,q);

    }
}