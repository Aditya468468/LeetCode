class Solution 
{
    public void generate(int idx,int[]nums,List<Integer> list,List<List<Integer>> ans)
    {
        if(idx==nums.length)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        //take it
        list.add(nums[idx]);
        generate(idx+1,nums,list,ans);
        //undo it.
        list.remove(list.size()-1);
        //Dont Take.
        generate(idx+1,nums,list,ans);


    }
    public int subsetXORSum(int[] nums) {
        
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        generate(0,nums,list,ans);
        int result=0;
        for(List<Integer> num:ans)
        {
            int value=0;
            for(int x:num)
            {
                value^=x;
            }
            result+=value;
        }
        
        return result;
    }
}