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
    public TreeNode createBinaryTree(int[][] descriptions) 
    {
        int n=descriptions.length;
        HashSet<Integer> isChild=new HashSet<>();
        HashMap<Integer,TreeNode> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int val=descriptions[i][0];
            int childVal=descriptions[i][1];
            isChild.add(childVal);
            TreeNode child=null;
            if(map.containsKey(descriptions[i][1]))
            {
                child=map.get(descriptions[i][1]);
            }
            else
            {
                child=new TreeNode(childVal);
                map.put(childVal, child);
            }
            
            boolean isLeft= descriptions[i][2]==1;
            if(!map.containsKey(val))
            {
                TreeNode node=new TreeNode(val);
                if(isLeft) node.left=child;
                else node.right=child;
                map.put(val,node);
            }
            else
            {
                TreeNode node=map.get(val);
                if(isLeft) node.left=child;
                else node.right=child;
            }

        }
        for(int i=0;i<n;i++)
        {
             int val=descriptions[i][0];
             if(!isChild.contains(val))
             {
                return map.get(val);
             }

        }
        

        return new TreeNode(-1);
        
    }
}