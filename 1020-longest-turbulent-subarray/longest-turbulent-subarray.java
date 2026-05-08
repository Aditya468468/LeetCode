class Solution {
    public int maxTurbulenceSize(int[] nums) 
    {
        // 1-> greater
        //0->Smaller.
        
        int maxLen=1;
        int prev=-1;
        int n=nums.length;
        int len=1;
        for(int i=1;i<n;i++)
        {
            if((prev==-1 ||prev==0) && nums[i-1]<nums[i])
            {
                len++;
                prev=1;
            }
            else if((prev==-1 || prev==1) && nums[i-1]>nums[i])
            {
                len++;
                prev=0;
            }
            else
            {
                maxLen=Math.max(len,maxLen);
                if(nums[i-1]==nums[i])
                {
                    len=1;
                    prev=-1;
                }
                else
                {
                    if(nums[i-1]<nums[i])
                    {
                        len=2;
                        prev=1;
                    }
                    else 
                    {
                        len=2;
                        prev=0;
                    }
                }
               

            }
        }

        return Math.max(maxLen,len);


        
    }
}