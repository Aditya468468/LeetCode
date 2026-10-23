class Solution 
{
    public int[] explore(int i,int j,char[][] grid,int[] curr)
    {
        //If Invalid return the curr
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)
        {
            return curr;
        }
        //Check if already visited
        if(grid[i][j]=='*') return curr;

        char move=grid[i][j];
        grid[i][j]='*';
        curr[0]=i;
        curr[1]=j;

      
        if(move=='R')
        {
            return explore(i,j+1,grid,curr);
        }
        else if(move=='L')
        {
            return explore(i,j-1,grid,curr);
        }
        else if(move=='U')
        {
            return explore(i-1,j,grid,curr);
        }
        else
        {
            return explore(i+1,j,grid,curr);
        }
    }

    public int[] lastVisitedCell(char[][] grid) 
    {
        return explore(0,0,grid,new int[2]);


    }
}