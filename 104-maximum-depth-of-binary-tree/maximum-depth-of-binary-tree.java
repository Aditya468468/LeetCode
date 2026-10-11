class Solution 
{
    
    public int maxDepth(TreeNode root) 
    {
        if(root==null) return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        int max=0;
        q.offer(root);

        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                if(node.left!=null)
                {
                    q.offer(node.left);
                }
                if(node.right!=null)
                {
                    q.offer(node.right);
                }
            }
            max++;
        }

        return max;

        
    }
}