/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution 
{

    public void path(TreeNode node,List<TreeNode> list,TreeNode x,List<TreeNode> ans)
    {
        if(node==null || !ans.isEmpty()) return; // if we have ans--> break early

        list.add(node);

        if(node==x) 
        {
            ans.addAll(list);
            return;
        }
        else
        {
            path(node.left,list,x,ans);
            path(node.right,list,x,ans);
        }

        list.remove(list.size()-1);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        List<TreeNode> list1=new ArrayList<>();
        path(root,new ArrayList<>(),p,list1);

        List<TreeNode> list2=new ArrayList<>();
        path(root,new ArrayList<>(),q,list2);

        //3,5 
        // 3,5,2,4
        int i=0;
        int j=0;
        TreeNode ans=null;
        while(i<list1.size() && j<list2.size())
        {
            TreeNode node1=list1.get(i);
            TreeNode node2=list2.get(j);
            if(node1!=node2)
            {
                break;
            }
            ans=node1;
            i++;
            j++;
        }
       
       
       return ans;

        
    }
}