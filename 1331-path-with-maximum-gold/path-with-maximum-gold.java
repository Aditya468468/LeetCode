class Solution 
{
    int maxGold=0;

    private void collect(int[][]grid,boolean[][]visited,int i,int j,int gold)
    {
        maxGold=Math.max(maxGold,gold); //Update
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)
        {
            return;
        }
        if(grid[i][j]==0) return;
        if(visited[i][j]==true) return;
        visited[i][j]=true;
        collect(grid,visited,i-1,j,gold+grid[i][j]); //UP
        collect(grid,visited,i+1,j,gold+grid[i][j]); //DOWN
        collect(grid,visited,i,j-1,gold+grid[i][j]); //LEFT
        collect(grid,visited,i,j+1,gold+grid[i][j]); //RIGHT

        visited[i][j]=false; //Backtrack.
        
    }
    public int getMaximumGold(int[][] grid) 
    {
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]!=0)
                {
                    collect(grid,new boolean[grid.length][grid[0].length],i,j,0);
                    //Start exploring the path.
                }

            }
        }

        return maxGold;
    }
}