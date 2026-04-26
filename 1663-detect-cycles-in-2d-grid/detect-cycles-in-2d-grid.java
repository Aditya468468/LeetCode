class Solution {

    private boolean dfs(char[][]grid,boolean [][]visited,int i,int j,int pr,int pc)
    {
        int n=grid.length;
        int m=grid[0].length;
        visited[i][j]=true;
        //up
        if(i>0 && grid[i-1][j]==grid[i][j])
        {
            if(!visited[i-1][j])
            {
                if(dfs(grid,visited,i-1,j,i,j)) return true;
            }
            else
            {
                if(pr!=i-1 || pc!=j) return true;
            }
        }
        //down
        if(i<n-1 && grid[i+1][j]==grid[i][j])
        {
            if(!visited[i+1][j])
            {
                if(dfs(grid,visited,i+1,j,i,j)) return true;
            }
            else
            {
                if(pr!=i+1 || pc!=j) return true;
            }
        }
        //top
        if(j>0 && grid[i][j-1]==grid[i][j])
        {
            if(!visited[i][j-1])
            {
                if(dfs(grid,visited,i,j-1,i,j)) return true;
            }
            else
            {
                if(pr!=i || pc!=j-1) return true;
            }
        }
        //dowm 
        if(j<m-1 && grid[i][j+1]==grid[i][j])
        {
            if(!visited[i][j+1])
            {
                if(dfs(grid,visited,i,j+1,i,j)) return true;
            }
            else
            {
                if(pr!=i || pc!=j+1) return true;
            }
        }

        return false;


    }
    public boolean containsCycle(char[][] grid) 
    {
        int n=grid.length;
        int m=grid[0].length;
        boolean [][]visited=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(!visited[i][j])
                {
                if(dfs(grid,visited,i,j,-1,-1)) return true;
                }
            }
        }

        return false;
        
    }
}