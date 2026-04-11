class Solution {
    private int count(int x,int digit)
    {
        int count=0;
        while(x!=0)
        {
            int ld=x%10;
            if(ld==digit)
            {
                count++;
            }
            x/=10;
        }
        return count;
    }
    public int countDigitOccurrences(int[] nums, int digit) 
    {
        int ans=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            ans+=count(nums[i],digit);
        }

        return ans;
        
    }
}