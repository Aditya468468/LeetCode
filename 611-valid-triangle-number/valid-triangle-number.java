class Solution {

    private int count(int[]nums,int x)
    {
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]>=x)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
    }

    public int triangleNumber(int[] nums) 
    {
        Arrays.sort(nums);
        // a+b>c
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int x=nums[i]+nums[j];
                int idx=count(nums,x);
                if(idx>j)
                {
                    ans+=idx-j-1;
                }
            }
        }
        return ans;
    }
}