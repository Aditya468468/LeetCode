class Solution 
{
    private void perm(int[]nums,boolean[]used,List<List<Integer>> ans, List<Integer> list)
    {
        if(list.size()==nums.length)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        //
        for(int i=0;i<nums.length;i++)
        {
            if(used[i]==true) continue;
            used[i]=true;
            list.add(nums[i]);
            perm(nums,used,ans,list);
            list.remove(list.size()-1);
            used[i]=false;
        }
    }
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> ans=new ArrayList<>();
        perm(nums,new boolean[nums.length],ans,new ArrayList<>());

        return ans;

        
    }
}