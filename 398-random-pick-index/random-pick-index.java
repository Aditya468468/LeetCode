class Solution {

    int []nums;
    Random rand=new Random();
    public Solution(int[] nums) 
    {
        this.nums=nums;
        
    }
    
    public int pick(int target) 
    {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==target)
            {
                list.add(i);
            }
        }
        int idx = rand.nextInt(list.size());
        return list.get(idx);


    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */