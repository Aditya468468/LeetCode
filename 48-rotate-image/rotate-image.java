class Solution {
    private void reverse(int[][]matrix,int row)
    {
        int i=0;
        int j=matrix.length-1;
        while(i<j)
        {
            int temp=matrix[row][i];
            matrix[row][i]=matrix[row][j];
            matrix[row][j]=temp;
            i++;
            j--;
        }

    }
    public void rotate(int[][] matrix) 
    {
        int n=matrix.length;
        if(n==0) return;
        //In-place Traspose.
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //Row-Reversal
        for(int i=0;i<n;i++)
        {
            reverse(matrix,i);
        }

        return;


        
    }
}