class Solution {
    public int[] countOppositeParity(int[] nums) 
    {
        
        int n=nums.length;
        int cntOdd=0;
        int cntEven=0;
        int []ans=new int[n];
        for(int i=n-1;i>=0;i--)
            {
                if(nums[i]%2==0)
                {
                    ans[i]=cntOdd;
                    cntEven++;
                }
                else
                {
                    ans[i]=cntEven;
                    cntOdd++;
                }
            }
        
        return ans;
        
    }
}