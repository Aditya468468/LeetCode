class Solution {
    public void comb(int idx,int[]nums,List<List<Integer>> ans,List<Integer> list,int target)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target<0 || idx==nums.length)
        {
            return;
        }
        // Lets Take it.
        list.add(nums[idx]);
        comb(idx+1,nums,ans,list,target-nums[idx]);
        // Backtrack.
        list.remove(list.size()-1);
        // Not Take Any Occ at that level.
        while(idx+1<nums.length && nums[idx]==nums[idx+1])
        {
            idx++;
        }
        comb(idx+1,nums,ans,list,target);

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        comb(0,candidates,ans,new ArrayList<>(),target);

        return ans;
       
    }
}