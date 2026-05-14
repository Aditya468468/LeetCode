class Solution {
    public boolean isGood(int[] nums) 
    {
        int max=Integer.MIN_VALUE;
        for(int x:nums)
        {
            if(x>max) max=x;
        }
        int n=nums.length;
        if(n!=max+1) return false;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=1;i<=max;i++)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        map.put(max,map.getOrDefault(max,0)+1);// Repeats
        for(int i=0;i<n;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)-1);
            if(map.get(nums[i])==0)
            {
                map.remove(nums[i]);
            }
        }


        return map.isEmpty();
    }
}