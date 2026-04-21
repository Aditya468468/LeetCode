class Solution 
{
    private void generate(int idx,int []nums,List<List<Integer>> ans,List<Integer> list)
    {
        ans.add(new ArrayList<>(list));//Every state is Valid Subset.

        for(int i=idx;i<nums.length;i++)
        {
            if(i>idx && nums[i-1]==nums[i]) continue;
            //Skiping Duplicates On Same Recursion Level
            list.add(nums[i]);
            generate(i+1,nums,ans,list);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        generate(0,nums,ans,new ArrayList<>());
        return ans;
      
    }
}



