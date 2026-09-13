class Solution 
{
    public void reverseRow(int [][]grid,int row,int i, int j)
    {
        while(i<j)
        {
            int temp=grid[row][i];
            grid[row][i]=grid[row][j];
            grid[row][j]=temp;
            i++;
            j--;
        }
    }
    public void shiftRow(int[][]grid,int row, int k)
    {
        int n=grid.length;
        int i=0;
        int j=n-1;
        k=k%n;
       
        reverseRow(grid,row,0,k-1);
        reverseRow(grid,row,k,n-1);
        reverseRow(grid,row,0,n-1);

    }
    public void reverseCol(int [][]grid,int col,int i, int j)
    {
        while(i<j)
        {
            int temp=grid[i][col];
            grid[i][col]=grid[j][col];
            grid[j][col]=temp;
            i++;
            j--;
        }
    }
    public void shiftCol(int[][]grid,int col, int k)
    {
        int n=grid.length;
        k=k%n;
       
        reverseCol(grid,col,0,k-1);
        reverseCol(grid,col,k,n-1);
         reverseCol(grid,col,0,n-1);

    }
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) 
    {
        for(int i=0;i<n;i++)
        {
            int row=i;
            int k=rowShift[i];
            shiftRow(grid,row,k);
        }

        for(int i=0;i<n;i++)
        {
            int col=i;
            int k=colShift[i];
            shiftCol(grid,col,k);
        }

        return grid;
        
    }
}