class Solution {
    public int[][] onesMinusZeros(int[][] grid) 
    {
        int n=grid.length;
        int m=grid[0].length;
        int []row=new int[n];
        int []col=new int[m];
        for(int i=0;i<n;i++)
        {
            int ones=0;
            int zeros=0;
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==0) zeros++;
                else ones++;
            }
            row[i]=ones-zeros;
        }
        for(int i=0;i<m;i++)
        {
            int ones=0;
            int zeros=0;
            for(int j=0;j<n;j++)
            {
                if(grid[j][i]==0) zeros++;
                else ones++;
            }
            col[i]=ones-zeros;
        }
        int [][]diff=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int effRow=row[i];
                int effCol=col[j];
                diff[i][j]=effRow+effCol;
            }
        }

        return diff;

        
    }
}