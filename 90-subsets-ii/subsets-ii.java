class Solution 
{
    private void generate(int idx,int[]nums,List<List<Integer>> ans,List<Integer> list)
    {
        if(idx==nums.length)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        //Take it.
        list.add(nums[idx]);
        generate(idx+1,nums,ans,list);
        //Backtrack.
        list.remove(list.size()-1);
        //Not take any of its occ in that rec level.
        int i=idx+1;
        while(i<nums.length && nums[idx]==nums[i])
        {
            i++;
        }
        generate(i,nums,ans,list);
    }

    
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        Arrays.sort(nums);// Imp to skip Duplicates.
        List<List<Integer>> ans=new ArrayList<>();
        generate(0,nums,ans,new ArrayList<>());

        return ans;
        
    }
}