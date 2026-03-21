class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) 
    {
        int n=grid.length;
        int m=grid[0].length;
        int r1=x;
        int r2=x+k-1;
        int c1=y;
        int c2=y+k-1;

        while(r1<r2 && r1<n && r2>=0)
        {
            for(int j=c1;j<=c2;j++)
            {
                int temp=grid[r1][j];
                grid[r1][j]=grid[r2][j];
                grid[r2][j]=temp;
            }
            r1++;
            r2--;
        }

        return grid;
        
    }
}