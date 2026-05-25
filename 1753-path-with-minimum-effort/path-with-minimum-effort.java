class Solution {

    private boolean canReach(int[][]heights,int i,int j, boolean visited[][],int k,int prev)
    {
        if(i<0 || i>=heights.length || j<0 || j>=heights[0].length) return false;
        if(visited[i][j]) return false;
        if(Math.abs(heights[i][j]-prev)>k) return false;
        if(i==heights.length-1 && j==heights[0].length-1) return true;
        visited[i][j]=true;
        if(canReach(heights,i+1,j,visited,k,heights[i][j])) return true;
        if(canReach(heights,i-1,j,visited,k,heights[i][j])) return true;
        if(canReach(heights,i,j+1,visited,k,heights[i][j])) return true;
        if(canReach(heights,i,j-1,visited,k,heights[i][j])) return true;

        return false;   
    }
    public int minimumEffortPath(int[][] heights) 
    {
        int n=heights.length;
        int m=heights[0].length;
        int low=0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(heights[i][j]<min) min=heights[i][j];
                if(heights[i][j]>max) max=heights[i][j];
            }
        }
        int high=max-min;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(canReach(heights,0,0,new boolean[n][m],mid,heights[0][0]))
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
}