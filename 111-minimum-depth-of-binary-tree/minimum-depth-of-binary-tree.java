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
class Solution {
    public int minDepth(TreeNode root) 
    {
        //BFS Approach
        Queue<TreeNode> q=new LinkedList<>();
        int nodes =1;
        if(root==null) return 0;
        q.offer(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i = 0;i<size;i++)
            {
                TreeNode node=q.poll();
                if(node.left==null && node.right==null) return nodes;
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }

            nodes++;

        }

        return -1;


        
        
    }
}