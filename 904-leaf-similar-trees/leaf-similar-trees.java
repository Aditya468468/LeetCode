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
    public void extractLeaves(TreeNode node,List<Integer> list)
    {
        if(node==null) return;
        if(node.left==null && node.right==null) //Leaf Node
        {
            list.add(node.val);
        }
        else
        {
            extractLeaves(node.left,list);
            extractLeaves(node.right,list);
        }

        return;
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) 
    {
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();

        extractLeaves(root1,list1);
        extractLeaves(root2,list2);

        if(list1.size()!=list2.size()) return false;

        for(int i=0;i<list1.size();i++)
        {
            if(!list1.get(i).equals(list2.get(i))) return false;
        }

        return true;
        
    }
}