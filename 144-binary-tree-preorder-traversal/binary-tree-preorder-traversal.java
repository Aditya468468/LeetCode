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
    public void traverseTree(TreeNode node,List<Integer> ans)
    {
        if(node==null) return;
        ans.add(node.val);
        traverseTree(node.left,ans);
        traverseTree(node.right,ans);
    }
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        List<Integer> ans=new ArrayList<>();
        traverseTree(root,ans);
        return ans;
        
    }
}
