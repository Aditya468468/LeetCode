class Solution 
{
    private void perm(int[]nums,boolean[]used,List<Integer> list,List<List<Integer>> ans)
    {
        if(list.size()==nums.length)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(used[i]) continue; //If the element has be used in parent trees,we cant use it.
            //mark
            used[i]=true;
            list.add(nums[i]);
            perm(nums,used,list,ans);
            //Back-track.
            list.remove(list.size()-1);
            used[i]=false;
        }

    }
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> ans=new ArrayList<>();
        perm(nums,new boolean[nums.length],new ArrayList<>(),ans);

        return ans;
        
    }
}