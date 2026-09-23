class Solution {
    public int minOperations(int[] nums, int x) 
    {
        //Maximum subarray with sum equal to ==Total-x
        // similar to Maximum Cards to Obtain Ques
        //Can be solved with presum+ HashMaps
        //Lets try Sliding window--> sum< need--> inc the sum, if sum>k--> dec the sum, if ==k capture the length
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int preSum=0;
        int totalSum=0;
        int n=nums.length;
       

        for(int num:nums)
        {
            totalSum+=num;
        }

        int k=totalSum-x;
        if(k<0) return -1;
        if (k==0) return n;
        int maxLen=Integer.MIN_VALUE;

        for(int i=0;i<n;i++)
        {
            preSum+=nums[i];
            int needed=preSum-k;
            if(map.containsKey(needed))
            {
                int len=i-map.get(needed);
                maxLen=Math.max(maxLen,len);
            }
            
            if(!map.containsKey(preSum)) //As we need maxLen 
            {
                map.put(preSum,i);
            }

        }
        
        if(maxLen==Integer.MIN_VALUE) return -1;
        return n-maxLen;

        
        
    }
}