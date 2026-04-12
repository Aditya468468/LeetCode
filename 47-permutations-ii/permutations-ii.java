class Solution 
{
    private void generate(int []nums,boolean[]used,List<List<Integer>> ans,List<Integer> list)
    {
        if(list.size()==nums.length)
        {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            
            if(used[i]==true) continue;
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
            used[i]=true;
            list.add(nums[i]);
            generate(nums,used,ans,list);
            used[i]=false;
            list.remove(list.size()-1);


        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) 
    {
        Arrays.sort(nums);
        List<List<Integer>> ans =new ArrayList<>();
        generate(nums,new boolean[nums.length],ans,new ArrayList<Integer>());

        return ans;
        
        
    }
}