class Solution {
    private int count(int idx,int[]nums,int k,Map<Integer,Integer> map)
    {
        if(idx==nums.length)
        {
            return 1;
        }
        int take=0;
        if(!map.containsKey(nums[idx]-k) && !map.containsKey(nums[idx]+k))
        {
            map.put(nums[idx],map.getOrDefault(nums[idx],0)+1);
            take+=count(idx+1,nums,k,map);
            //backtrack 
            map.put(nums[idx],map.getOrDefault(nums[idx],0)-1);
            if(map.get(nums[idx])==0) map.remove(nums[idx]);

        }
        int notTake=count(idx+1,nums,k,map);
        return take+notTake;

    }
    public int beautifulSubsets(int[] nums, int k) 
    {

        return count(0,nums,k,new HashMap<>())-1;
        
    }
}