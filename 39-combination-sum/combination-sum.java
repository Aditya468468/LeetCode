class Solution 
{
    private void comb(int idx,int[]nums,List<List<Integer>> ans,List<Integer> list,int target)
    {
        if(target<0) return; //pruning
        if(target==0)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(idx==nums.length)
        {
            if(target==0)
            {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        //Take nd stay.
        list.add(nums[idx]);
        comb(idx,nums,ans,list,target-nums[idx]);
        // Redo.
        list.remove(list.size()-1);
        //Not take.
        comb(idx+1,nums,ans,list,target);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans=new ArrayList<>();
        comb(0,candidates,ans,new ArrayList<Integer>(),target);

        return ans;
    }
}