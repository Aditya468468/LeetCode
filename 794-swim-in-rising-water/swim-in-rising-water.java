class Solution {

    public boolean canReach(int[][]grid,int i,int j, boolean [][]visited,int k)
    {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)
        {
            return false; // Boundaries 
        }
        if(visited[i][j]==true)
        {
            return false; // Save from self loop
        }
        if(grid[i][j]>k)
        {
            return false; // Water level is High
        }
        if(i==grid.length-1 && j==grid[0].length-1)
        {
            return true;
        }
        visited[i][j]=true;
        if(canReach(grid,i+1,j,visited,k)) return true;
        if(canReach(grid,i-1,j,visited,k)) return true;
        if(canReach(grid,i,j+1,visited,k)) return true;
        if(canReach(grid,i,j-1,visited,k)) return true;


        return false;
    
    }
    public int swimInWater(int[][] grid) 
    {
        int n=grid.length;
        int m=grid[0].length;
       // int low=0;
        int low=Math.max(grid[0][0],grid[n-1][m-1]);
        //You MUST at least wait for start/end cells->GPT
        int high=Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]>high)
                {
                    high=grid[i][j];
                }
            }
        }
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(canReach(grid,0,0,new boolean[n][m],mid))
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