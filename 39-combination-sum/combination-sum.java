class Solution {

    public void count(int idx,int[]nums,List<List<Integer>> ans,List<Integer> list,int sum)
    {
        if(sum==0)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(sum<0 || idx==nums.length)
        {
            return;
        }
        for(int i=idx;i<nums.length;i++)
        {
            list.add(nums[i]);
            count(i,nums,ans,list,sum-nums[i]);
            //Back track;
            list.remove(list.size()-1);
        
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        List<List<Integer>> ans=new ArrayList<>();
        count(0,candidates,ans,new ArrayList<>(),target);
        return ans;
        
    }
}