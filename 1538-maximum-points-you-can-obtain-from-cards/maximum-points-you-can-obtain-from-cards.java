class Solution {
    public int maxScore(int[] cardPoints, int k) 
    {
        int n=cardPoints.length;
        int len=n-k;
        int minSum=Integer.MAX_VALUE ;
        int sum=0;
        int left=0;
        int totalSum=0;
        for(int right=0;right<n;right++)
        {
            totalSum+=cardPoints[right];
            sum+=cardPoints[right];
            while(right-left+1>len)
            {
                sum-=cardPoints[left];
                left++;
            }
            if(right-left+1==len)
            {
                minSum=Math.min(minSum,sum);

            }
        }

        return totalSum-minSum;
        
    }
}