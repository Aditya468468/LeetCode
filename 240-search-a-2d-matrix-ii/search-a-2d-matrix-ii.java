class Solution {
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n*m;i++)
        {
           if(matrix[i/m][i%m]==target) return true;
        }
        return false;


      
    }
}