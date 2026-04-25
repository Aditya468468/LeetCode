class Solution {
    public int[][] onesMinusZeros(int[][] grid) 
    {
        int n=grid.length;
        int m=grid[0].length;
        int []row=new int[n];
        int []col=new int[m];
        for(int i=0;i<n;i++)
        {

            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    row[i]++;
                    col[j]++;
                } 
                
            }
        }
    
        int [][]diff=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int zerosRow=m-row[i];
                int zerosCol=n-col[j];
                diff[i][j]=row[i]+col[j]-zerosRow-zerosCol;
            }
        }

        return diff;

        
    }
}