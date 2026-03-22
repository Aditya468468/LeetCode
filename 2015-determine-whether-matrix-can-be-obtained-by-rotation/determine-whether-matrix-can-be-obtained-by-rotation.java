class Solution {
    private void reverse(int[][]matrix,int r)
    {
        int i=0;
        int j=matrix.length-1;
        while(i<j)
        {
            int temp=matrix[r][i];
            matrix[r][i]=matrix[r][j];
            matrix[r][j]=temp;
            i++;
            j--;

        }
    }
    public void rotate(int[][] mat)
    {
        int n=mat.length;
        int m=mat[0].length;
        //transpose
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        for(int i=0;i<n;i++)
        {
            reverse(mat,i);
        }

    }
    public boolean findRotation(int[][] mat, int[][] target) 
    {
        for(int i=0;i<4;i++)
        {
            if(Arrays.deepEquals(mat,target)) return true; // For 2-D array.
            //Arrays.equals()-> Just for 1-D array.
            rotate(mat);
    
        }

        return false;
        
    }
}