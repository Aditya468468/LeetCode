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
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        Stack<TreeNode> st=new Stack<>();
        TreeNode curr=root;
        List<Integer> list=new ArrayList<>();

        while(true)
        {
            if(curr!=null) //Seen it 1st time
            {
                list.add(curr.val);
                st.push(curr);
                curr=curr.left;
            }
            else
            {
                if(st.isEmpty()) break;
                TreeNode node=st.pop();
                curr=node.right;
            }
        }

        return list;
        
    }
}