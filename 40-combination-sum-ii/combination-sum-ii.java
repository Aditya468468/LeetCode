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
      
        for(int i=idx;i<nums.length;i++)
        {
            if(i>idx && nums[i-1]==nums[i])
            {
                continue;
            }
            list.add(nums[i]);
            generate(i+1,nums,target-nums[i],list,ans);
            list.remove(list.size()-1);
        }

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        generate(0,candidates,target,new ArrayList<>(),ans);


        return ans;

        
    }
}