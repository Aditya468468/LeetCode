class Solution {
    
    private void perm(int []nums,List<Integer> list,boolean[]used,List<List<Integer>> ans)
    {
        if(list.size()==nums.length)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(used[i])
            {
                continue;
            }
            used[i]=true;
            list.add(nums[i]);
            perm(nums,list,used,ans);
            // Backtrack.
            list.remove(list.size()-1);
            used[i]=false;
        }
    }
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        perm(nums,new ArrayList<>(),new boolean[nums.length], ans);
        return ans;
        
    }
}