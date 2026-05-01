class Solution {
    public int maxRotateFunction(int[] nums) 
    {
        int n=nums.length;
        long totalSum=0;
        long f0=0;
        for(int i=0;i<n;i++)
        {
            totalSum+=nums[i];
            f0+=(long)(nums[i])*i;
        }
        //Lets use-> sum(i)=prev-(nums[i]*(n-1))+totalSum-nums[i].
        long prev=f0;
        long max=f0;
        for(int i=n-1;i>=0;i--)
        {
            long sum=prev-((long)nums[i]*(n-1))+totalSum-nums[i];
            prev=sum;
            if(sum>max) max=sum;
        }

        return (int)max;
        
    }
}