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

    public int countNodes(TreeNode node)
    {
        if(node==null) return 0;

        int size=1;

        size+=countNodes(node.left);
        size+=countNodes(node.right);

        return size;
    }
    public int dfs(TreeNode node)
    {

        if(node==null) return 0;

        int left=dfs(node.left);
        int right=dfs(node.right);

        int sum=left+right+node.val;

        int n = countNodes(node);

        if(sum/n==node.val) 
        {
            ans++;
        }

        return sum;


    }
    public int averageOfSubtree(TreeNode root) 
    {
        dfs(root);

        return ans;
        
    }
}