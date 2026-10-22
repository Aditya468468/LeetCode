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
    
    public List<Integer> inorderTraversal(TreeNode root) 
    {

        List<Integer> list=new ArrayList<>();
        if(root==null) return list;

        Stack<TreeNode> st=new Stack<>();

        TreeNode curr=root;

        while(true)
        {
            if(curr!=null) // We have found a new Node
            {
                st.push(curr); //Store it 
                curr=curr.left; // And Go to the left

            }
            else // We have reached to null
            {
                if(st.isEmpty()) break; //Nothing remains

                TreeNode node=st.pop(); // Gives us prev Node
                list.add(node.val); // Add to list
                curr=node.right; // And move to its right
            }

        }

        return list;

       
    }
}