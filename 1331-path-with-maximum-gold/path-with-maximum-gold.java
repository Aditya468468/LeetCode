class Solution 
{
    int maxGold=0;
    private void collect(int i,int j,int[][]grid,int gold)
    {
        maxGold=Math.max(maxGold,gold);
        int n=grid.length;
        int m=grid[0].length;
        if(i<0 || i>=n || j<0 || j>=m) return;
        if(grid[i][j]==0) return;
        int currGold=grid[i][j];
        grid[i][j]=0;
        collect(i-1,j,grid,gold+currGold);
        collect(i+1,j,grid,gold+currGold);
        collect(i,j-1,grid,gold+currGold);
        collect(i,j+1,grid,gold+currGold);
        grid[i][j]=currGold;
        return;
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
                    collect(i,j,grid,0);
                }
            }
        }

        return maxGold;

    }
}