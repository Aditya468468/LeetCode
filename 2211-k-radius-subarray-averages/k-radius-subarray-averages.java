class Solution {
    public int[] getAverages(int[] nums, int k) 
    {
        if(k==0) return nums;
        int n=nums.length;
        int []ans=new int[n];
        Arrays.fill(ans,-1);
        int size=2*k+1;
        int left=0;
        long sum=0;
        for(int right=0;right<n;right++)
        {
            sum+=nums[right];

            while(right-left+1>size)
            {
                sum-=nums[left];
                left++;
            }
            if(right-left+1==size)
            {
                int idx=left+k;
                ans[idx]=(int)(sum/size);
            }

        }

        return ans;
        
    }
}