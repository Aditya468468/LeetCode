class Solution {
    public int maxDistance(int[] colors) 
    {
        int max=Integer.MIN_VALUE;
        int n=colors.length;
        int first=colors[0];
        int last=colors[n-1];
        if(first!=last) return n-1;
        for(int i=1;i<n-1;i++)
        {
            if(colors[i]!=first)
            {
                int curr=Math.max(i,n-1-i);
                if(curr>max) max=curr;
            }
        }
        return max;
    }
}