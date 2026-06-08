class Solution 
{
    public void generate(int idx,int[]nums,int target,List<Integer> list,List<List<Integer>> ans)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target<0 || idx==nums.length) return;
        // Pick and Stay.
        list.add(nums[idx]);//Pick.
        generate(idx,nums,target-nums[idx],list,ans);// recurse.
        list.remove(list.size()-1); //Undo.
        //Not Take and Move.
        generate(idx+1,nums,target,list,ans);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {

        List<List<Integer>> ans=new ArrayList<>();
        generate(0,candidates,target,new ArrayList<>(),ans);

        return ans;

        
    }
}