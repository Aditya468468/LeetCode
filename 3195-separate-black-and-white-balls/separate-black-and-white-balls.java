class Solution {
    public long minimumSteps(String s) 
    {
        char[]nums=s.toCharArray();
        int n=nums.length;
        long ops=0;
        long len=0;
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