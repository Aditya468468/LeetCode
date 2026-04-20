class Solution {
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
        for(int i=idx;i<nums.length;i++)
        {
            if(i>idx && nums[i]==nums[i-1]) continue;
            if(nums[i]>target) break; //Pruning!!
            list.add(nums[i]);
            comb(i+1,nums,ans,list,target-nums[i]);
            list.remove(list.size()-1);

        }
       

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        comb(0,candidates,ans,new ArrayList<>(),target);

        return ans;
       
    }
}