class Solution {
    public int maxDistance(int[] colors) 
    {
        int max=Integer.MIN_VALUE;
        int n=colors.length;
        for(int i=0;i<n;i++)
        {
            int curr=colors[i];
            for(int j=i+1;j<n;j++)
            {
                if(colors[j]!=curr)
                {
                    int dis=j-i;
                    if(dis>max) max=dis;

                }
            }
        }

        return max;
        
    }
}