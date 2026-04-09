class Solution {

    private void generate(int idx,List<List<Integer>> ans,List<Integer> list,int []nums)
    {
        if(idx==nums.length)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        //Take
        list.add(nums[idx]);
        generate(idx+1,ans,list,nums);

        //Backtrack->(undo)
        list.remove(list.size()-1);

        //Not take
        generate(idx+1,ans,list,nums);
    }
    public List<List<Integer>> subsets(int[] nums) 
    {

        List<List<Integer>> ans=new ArrayList<>();

        generate(0,ans,new ArrayList<>(),nums);

        return ans;
        
    }
}