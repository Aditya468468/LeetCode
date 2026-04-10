class Solution 
{
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
        //Lets take and stay.
        list.add(nums[idx]);
        comb(idx,nums,ans,list,target-nums[idx]);
        list.remove(list.size()-1);//backtrack.

        //Lets Not take nd Move.
        comb(idx+1,nums,ans,list,target);


    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        List<List<Integer>> ans=new ArrayList<>();
        comb(0,candidates,ans,new ArrayList<>(),target);

        return ans;   
    }
}