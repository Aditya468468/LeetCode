class Solution {
    public int maxWidthOfVerticalArea(int[][] points) 
    {
        Arrays.sort(points,(a,b)->
        {
            return a[0]-b[0];
        });
        int max=0;
        for(int i=1;i<points.length;i++)
        {
            int gap=points[i][0]-points[i-1][0];
            max=Math.max(gap,max);

        }

        return max;
        
    }
}