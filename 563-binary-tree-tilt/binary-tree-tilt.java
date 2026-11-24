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
    public int ans=0;
    public int dfs(TreeNode node)
    {
        if(node==null) return 0;

        int left=dfs(node.left);
        int right=dfs(node.right);

        ans+=Math.abs(left-right); //thats what we need to calculate at that sub-tree lvl

        return node.val+left+right; //this what it will send up to the call from above tree.

    }
    public int findTilt(TreeNode root) 
    {

        dfs(root);

        return ans;
        
    }
}