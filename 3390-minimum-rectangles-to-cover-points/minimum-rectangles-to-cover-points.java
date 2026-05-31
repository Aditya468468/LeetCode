class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) 
    {
        int n=points.length;
        Arrays.sort(points,(a,b)->
        {
            if(a[0]!=b[0])
            {
                return a[0]-b[0];
            }
            else 
            {
                return a[1]-b[1];
            }
        });
        //Always take the largest width.soo ==w is useful.
        int currX=points[0][0];
        int totalRec=0;
        for(int i=0;i<n;i++)
        {
            if(points[i][0]-currX>w)
            {
                totalRec++;
                currX=points[i][0];
            }
            
        }

        return totalRec+1; //+1 for the last




        
    }
}