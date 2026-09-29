
class Solution 
{
    public void traverseTree(TreeNode node,List<Integer> ans)
    {
        if(node==null) return;
        traverseTree(node.left,ans);
        traverseTree(node.right,ans);
        ans.add(node.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) 
    {
        List<Integer> ans=new ArrayList<>();
        traverseTree(root,ans);
        return ans;
        
    }
}
