class Solution {
    public int minFlipsMonoIncr(String s) 
    {
        char[]nums=s.toCharArray();
        int n=nums.length;
        //"00110"
        //Edge case-> 00000 or 11111-> if All 0 then, flips->2, if all Ones-> flips->3
        int totalZeros=0;
        int totalOnes=0;
        for(int i=0;i<n;i++)
        {
            char x=nums[i];
            if(x=='0') totalZeros++;
            else totalOnes++;
        }
        int minFlips=Math.min(totalZeros,totalOnes);
        //Now it all depends on Num of 1's in the (0 to ith idx) and num of 0's in
        // the ( (i+1}th idx to n-1)--> So we Need Prefix states.
        int []prefixOnes=new int[n];
        int []suffixZeros=new int[n];
        int ones=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]=='1')
            {
                ones++;
            }
            prefixOnes[i]=ones;
        }
        int zeros=0;
        for(int i=n-1;i>=0;i--)
        {
            if(nums[i]=='0')
            {
                zeros++;
            }
            suffixZeros[i]=zeros;
        }
        // Now lets calculate.
        for(int i=0;i<n-1;i++)
        {
            int flips=prefixOnes[i]+suffixZeros[i+1];
            minFlips=Math.min(minFlips,flips);
        }
    
        return minFlips;
    }
}