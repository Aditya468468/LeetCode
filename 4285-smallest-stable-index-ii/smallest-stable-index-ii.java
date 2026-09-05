class Solution {
    public int firstStableIndex(int[] nums, int k) 
    {
        int n=nums.length;
        int []preMax=new int[n];
        int []suffMin=new int[n];

        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
            {
                if(nums[i]>max)
                {
                    max=nums[i];
                }
                preMax[i]=max;
            }
        for(int i=n-1;i>=0;i--)
            {
                if(nums[i]<min)
                {
                    min=nums[i];
                }
                suffMin[i]=min;
            }
        for(int i=0;i<n;i++)
            {
                int maxi=preMax[i];
                int mini=suffMin[i];
                if(maxi-mini<=k)
                {
                    return i;
                }
            }

        return -1;
    }
}