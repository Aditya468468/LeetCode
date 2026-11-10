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
    public void calculate(TreeNode node,int sum,int targetSum,List<Integer> list, List<List<Integer>> ans)
    {
        if(node==null) return;

        int value=node.val;
        list.add(value);
        sum+=value;

        if(node.left==null && node.right==null)
        {
            if(sum == targetSum) // If yes, add it
            {
              ans.add(new ArrayList<>(list));
            }

            list.remove(list.size()-1);
            return;
        }
        //Lets leave early termination for now
    
        calculate(node.left,sum,targetSum,list,ans);//Go left
        calculate(node.right,sum,targetSum,list,ans); // Go Right

        //Backtrack-When both left and right--> We backtrack and delete elements from list
        list.remove(list.size()-1);

        return;

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) 
    {
        List<List<Integer>> ans=new ArrayList<>();

        calculate(root,0,targetSum,new ArrayList<>(),ans);

        return ans;
        
    }
}