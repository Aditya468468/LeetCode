class Solution 
{
    private void generate(int idx,int[]nums, int target,List<Integer>list,List<List<Integer>> ans)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target<0 || idx==nums.length) return;
        //Lets Pick it.
        list.add(nums[idx]);
        generate(idx+1,nums,target-nums[idx],list,ans);
        list.remove(list.size()-1);
        //Skip,But Skip all its Occ at that level.
        while(idx<nums.length-1 && nums[idx+1]==nums[idx])
        {
            idx++; // Skips.
        }
        generate(idx+1,nums,target,list,ans);

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        generate(0,candidates,target,new ArrayList<>(),ans);


        return ans;

        
    }
}