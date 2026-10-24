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

class Pair
{
    TreeNode node;
    int count;

    public Pair(TreeNode node, int count)
    {
        this.node=node;
        this.count=count;
    }
}
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) 
    {
        Stack<Pair> st=new Stack<>();
      
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;

        st.push(new Pair(root,1));

        while(!st.isEmpty())
        {
            Pair p=st.pop();
            int count=p.count;
            TreeNode node=p.node;
            if(count==1)
            {
                st.push(new Pair(node,2));
                if(node.left!=null)
                {
                    st.push(new Pair(node.left,1));
                }
            }
            else if(count==2)
            {
                st.push(new Pair(node,3));
                if(node.right!=null)
                {
                    st.push(new Pair(node.right,1));
                }
            }
            else if(count==3)
            {
                list.add(node.val);
            }

        }


        return list;



        
    }
}