class Solution 
{
    private void generate(int idx,int[]nums,List<Integer> list,List<List<Integer>> ans)
    {
        //Whenever we have 2 options a Idx-> We use Pick/Not Pick or
        //Pick A/Pick B etc 
        if(idx==nums.length)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        //Take That Idx,
        list.add(nums[idx]);
        generate(idx+1,nums,list,ans);
        //Backtrack/Undo it-> As List have a same ref-> Need to undo to try others.
        list.remove(list.size()-1);
        //Not take.
        generate(idx+1,nums,list,ans); //Just move to next idx.
    }
    public List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>> ans=new ArrayList<>();
        generate(0,nums,new ArrayList<>(),ans);

        return ans;

        
    }
}