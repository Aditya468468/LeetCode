class Solution {
    public int longestSubsequence(int[] nums) 
    {
        int xor=0;
        int n=nums.length;
        int non_Zero=0;
        for(int i=0;i<nums.length;i++)
        {
            xor^=nums[i];
            if(nums[i]!=0)
            {
                non_Zero++;
            }

        }

        if(xor!=0) return n;
        else if(non_Zero==0)
        {
            return 0;
        }
        else return n-1;
        
    }
}