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
    public boolean isSame(TreeNode p,TreeNode q)
    {
        if(p==null && q==null) return true;

        if(p==null  || q==null) return false;

        if(p.val!=q.val) return false;

        return isSame(p.left,q.left) && isSame(p.right,q.right);
    }
    public boolean check(TreeNode node,TreeNode subRoot)
    {
        if(node==null) return false; //We reached null without a match

        boolean sub=isSame(node,subRoot);

        if(sub==true) return true; //Hurray we Found a Match

        return check(node.left,subRoot) || check(node.right,subRoot);


    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) 
    {

        return check(root,subRoot);
    }
}