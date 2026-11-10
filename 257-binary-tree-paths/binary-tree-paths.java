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
    public void generate(TreeNode node,StringBuilder str, List<String> ans)
    {
        if(node==null) return;
        //store original length--> Benefical as the digit can be variable
        // 100,1000,-12 etc--> we wont know how much to backtrack

        int originalLength=str.length();

        int value=node.val;
      
        if(node.left==null && node.right==null)
        {
            str.append(value);

            ans.add(new StringBuilder(str).toString());
        }  
        else
        {
            str.append(value);
            str.append("->");
            generate(node.left,str,ans);
            generate(node.right,str,ans);

        }

        //Backtracking
        str.setLength(originalLength);
        //Reset back to its prev length !!


        return;
        
    }
    public List<String> binaryTreePaths(TreeNode root) 
    {
        List<String> ans=new ArrayList<>();

        generate(root,new StringBuilder(),ans);

        return ans;
        
    }
}