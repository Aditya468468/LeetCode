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
    public void preOrderTraversal(TreeNode node,List<TreeNode> list)
    {
        if(node==null) return;

        list.add(node);
        preOrderTraversal(node.left,list);
        preOrderTraversal(node.right,list);
    }
    public void flatten(TreeNode root) 
    {
        List<TreeNode> preOrder=new ArrayList<>();

        preOrderTraversal(root,preOrder);

        TreeNode prevNode=null;
        for(int i=0;i<preOrder.size();i++)
        {
            TreeNode curr=preOrder.get(i);

            if(prevNode==null)
            {
                curr.left=null;
            }
            else
            {
                prevNode.right=curr;
                prevNode.left=null;
            }

            prevNode=curr;
        }

        return;



        
    }
}