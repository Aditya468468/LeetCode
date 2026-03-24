class Solution {

    public int triangleNumber(int[] nums) 
    {
        Arrays.sort(nums);
        int n=nums.length;
        int ans=0;
        for(int k=n-1;k>=2;k--)
        {
            int i=0;
            int j=k-1;
            while(i<j)
            {
                int sum=nums[i]+nums[j];
                if(sum>nums[k])
                {
                    ans+=(j-i);
                    j--;
                }
                else
                {
                    i++;
                }

            }
        }
        return ans;
    }
}