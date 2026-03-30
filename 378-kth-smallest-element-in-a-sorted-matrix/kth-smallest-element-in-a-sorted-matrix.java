class Solution {
    private int upperBound(int [][]matrix,int row,int x)
    {
        int low=0;
        int high=matrix[0].length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(matrix[row][mid]<=x)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return low;

    }
    public int countSmallerEqual(int[][]matrix,int x)
    {
        int n=matrix.length;
        int m=matrix[0].length;
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            cnt+=upperBound(matrix,i,x);
        }
        return cnt;
    }
    public int kthSmallest(int[][] matrix, int k) 
    {
        int n=matrix.length;
        int m=matrix[0].length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(matrix[i][0]<min) min=matrix[i][0];
            if(matrix[i][m-1]>max) max=matrix[i][m-1];
        }
        // Search space
        int low=min;
        int high=max;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int count=countSmallerEqual(matrix,mid);
            if(count<k) low=mid+1;
            else high=mid-1;
        }

        return low;

      
    }
}