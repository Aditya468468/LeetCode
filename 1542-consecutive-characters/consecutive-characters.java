class Solution {
    public int maxPower(String s) 
    {
        char[]nums=s.toCharArray();
        int n=nums.length;
        if(n==0) return 0;
        char curr=nums[0];
        int max=1;
        int len=1;
        for(int i=1;i<n;i++)
        {
            if(nums[i]==curr)
            {
                len++;
            }
            else
            {
                max=Math.max(max,len);
                len=1;
                curr=nums[i];
            }
        }
        max=Math.max(max,len);
        
        return max;
    }
}