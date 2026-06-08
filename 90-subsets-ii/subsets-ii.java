class Solution 
{
    private void generate(int idx,int[]nums,List<Integer> list,List<List<Integer>> ans)
    {
        if(idx==nums.length)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        // Take it.
        list.add(nums[idx]);
        generate(idx+1,nums,list,ans);
        list.remove(list.size()-1);
        //Not Take it, So We wont take Any occ at that level.
        while(idx<nums.length-1 && nums[idx]==nums[idx+1])
        {
            idx++;
        }
        generate(idx+1,nums,list,ans);

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        generate(0,nums,new ArrayList<>(), ans);

        return ans;

        
    }
}