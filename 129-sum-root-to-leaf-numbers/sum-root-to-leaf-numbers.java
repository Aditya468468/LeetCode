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
    public void dfs(TreeNode node,StringBuilder str,List<String> list)
    {
        if(node==null) return;
        str.append(node.val);

        if(node.left==null && node.right==null)
        {
            list.add(new String(str.toString()));
        }
        else
        {
            dfs(node.left,str,list);
            dfs(node.right,str,list);
        }

        //Backtrack
        str.deleteCharAt(str.length()-1);

        return;
    }
    public int sumNumbers(TreeNode root) 
    {

        List<String> list=new ArrayList<>();

        dfs(root,new StringBuilder(),list);

        int sum=0;

        for(int i=0;i<list.size();i++)
        {
            int value=Integer.parseInt(list.get(i));
            sum+=value;
        }

        return sum;
        
    }
}