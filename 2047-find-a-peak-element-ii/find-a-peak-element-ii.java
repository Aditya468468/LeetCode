class Solution {
    public int[] findPeakGrid(int[][] mat) 
    {
        int n=mat.length;
        int m=mat[0].length;
        int low=0;
        int high=m-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int max=Integer.MIN_VALUE;
            int maxRow=-1;
            for(int i=0;i<n;i++)
            {
                if(mat[i][mid]>max)
                {
                    max=mat[i][mid];
                    maxRow=i;
                }
                    
            }
            int left=-1;
            int right=-1;
            if(mid-1>=0) left=mat[maxRow][mid-1];
            if(mid+1<m) right=mat[maxRow][mid+1];
            if(max>right && max>left)
            {
                return new int[]{maxRow,mid};
            }
            else if(max>left) low=mid+1;
            else high=mid-1;
        }

        return new int[]{-1,-1};

        
    }
}