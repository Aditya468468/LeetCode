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
    public int leftHeight(TreeNode node)
    {
        int ht=0;
        while(node!=null)
        {
            node=node.left;
            ht++;
        }

        return ht;
    }
    public int rightHeight(TreeNode node)
    {
        int ht=0;
        while(node!=null)
        {
            node=node.right;
            ht++;
        }

        return ht;
    }
    
    public int count(TreeNode node)
    {
        if(node==null) return 0;

        int right=rightHeight(node);
        int left=leftHeight(node);

        if(right==left)
        {
            return (int)(Math.pow(2,right)-1);
        }

        return 1+count(node.left)+count(node.right);
    }

    public int countNodes(TreeNode root) 
    {

        return count(root);

        
    }
}