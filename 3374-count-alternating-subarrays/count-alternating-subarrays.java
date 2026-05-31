class Solution {
    public long countAlternatingSubarrays(int[] nums) 
    {
        int len=1;
        int prev=nums[0];
        long total=0;
        for(int i=1;i<nums.length;i++)
        {
            int curr=nums[i];
            if(prev!=curr)
            {
                len++;
                prev=curr;
            }
            else
            {
                total+=(1L)*(len)*(len+1)/2;
                len=1;
                prev=curr;
            }
        }
        total+=(1L)*(len)*(len+1)/2;


        return total;
        
    }
}