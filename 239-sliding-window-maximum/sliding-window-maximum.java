class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int n=nums.length;
        int []ans=new int[n-k+1];

        int left=0;
        for(int right=0;right<n;right++)
        {
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);

            while(right-left+1>k)
            {
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0)
                {
                    map.remove(nums[left]);
                }
                left++;
            }

            if(right-left+1==k)
            {
                ans[right-k+1]=map.lastKey();
            }

        }

        return ans;
        
    }
}