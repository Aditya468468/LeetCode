class Solution {
    public long minimumSteps(String s) 
    {
        char[]nums=s.toCharArray();
        int n=nums.length;
        long ops=0;
        long len=0; //How many Ones-> Zero has to Cross to Come front of 1's
        for(int i=0;i<n;i++)
        {
            if(nums[i]=='1')
            {
                len++;
            }
            else if(nums[i]=='0')
            {
                ops+=len;
            }
        }

        return ops;
        
    }
}