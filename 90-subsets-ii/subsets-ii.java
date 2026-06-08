class Solution 
{
    private void generate(int idx,int[]nums,List<Integer> list,List<List<Integer>> ans)
    {
        //Every state is an Ans.
        ans.add(new ArrayList<>(list));

        for(int i=idx;i<nums.length;i++)
        {
            if(i>idx && nums[i-1]==nums[i])
            {
                continue;
            }
            list.add(nums[i]);
            generate(i+1,nums,list,ans);
            list.remove(list.size()-1);
        }

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        generate(0,nums,new ArrayList<>(), ans);

        return ans;

        
    }
}