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
    public boolean isEvenOddTree(TreeNode root) 
    {
        if(root==null) return true;

        int level=0;
        Queue<TreeNode> q=new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty())
        {
            int prev=-1;
            int size=q.size();

            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                int y=node.val;

                if(i==0) 
                {
                    prev=y;
                    if(level%2==0)
                    {
                        if(y%2==0)
                        {
                            return false;
                        }
                    }
                    else
                    {
                        if(y%2!=0)
                        {
                            return false;
                        }
                    }
                }
                else
                {
                    if(level%2==0)
                    {
                        if(y%2==0)
                        {
                            return false;
                        }
                        if(prev>=y) 
                        {
                            return false;
                        }
                    }
                    else
                    {
                        if(y%2!=0)
                        {
                            return false;
                        }

                        if(prev<=y) 
                        {
                            return false;
                        }
                    }

                    prev=y;
                }

                //Inserting 
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }

            level++;
        }


        return true;


        
    }
}