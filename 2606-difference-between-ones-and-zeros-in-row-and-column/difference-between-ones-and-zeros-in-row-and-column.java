class Solution {
    public int[][] onesMinusZeros(int[][] grid) 
    {
        HashMap<Integer,int[]> row=new HashMap<>();
        HashMap<Integer,int[]> col=new HashMap<>();
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++)
        {
            int ones=0;
            int zeros=0;
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==0) zeros++;
                else ones++;
            }
            row.put(i,new int[]{zeros,ones});
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
            col.put(i,new int[]{zeros,ones});
        }
        int [][]diff=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int[] rowData=row.get(i);
                int[] colData=col.get(j);
                int onesRow=rowData[1];
                int zerosRow=rowData[0];
                int onesCol=colData[1];
                int zerosCol=colData[0];
                diff[i][j]=onesRow+onesCol-zerosRow-zerosCol;

            }
        }

        return diff;

        
    }
}