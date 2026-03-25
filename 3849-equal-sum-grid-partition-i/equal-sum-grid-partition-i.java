class Solution {
    public boolean canPartitionGrid(int[][] grid) 
    {
        int n=grid.length;
        int m=grid[0].length;
        long [][]prefix=new long[n+1][m+1];
    for(int i=1;i<=n;i++)
    {
    for(int j=1;j<=m;j++)
    {
     prefix[i][j]=grid[i-1][j-1]+prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1];
    }
    }
    long totalSum=prefix[n][m];
    if(totalSum%2==1) return false; //--> Odd cant be spilt into 2 equal parts.
    
    for(int i=1;i<=n;i++)
    {
        long sum=prefix[i][m];
        if(sum*2==totalSum) return true;
    }
    for(int j=1;j<=m;j++)
    {
        long sum=prefix[n][j];
        if(sum*2==totalSum) return true;
    }

    return false;



        
    }
}