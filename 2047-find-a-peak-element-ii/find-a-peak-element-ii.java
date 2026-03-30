class Solution {
    public int[] findPeakGrid(int[][] mat) 
    {
        int n=mat.length;
        int m=mat[0].length;
        int low=0;
        int high=n-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int max=Integer.MIN_VALUE;
            int maxCol=-1;
            for(int i=0;i<m;i++)
            {
                if(mat[mid][i]>max)
                {
                    max=mat[mid][i];
                    maxCol=i;
                }
                    
            }
            int up=-1;
            int down=-1;
            if(mid-1>=0) up=mat[mid-1][maxCol];
            if(mid+1<n) down=mat[mid+1][maxCol];
            if(max>up && max>down)
            {
                return new int[]{mid,maxCol};
            }
            else if(max>up) low=mid+1;
            else high=mid-1;
        }

        return new int[]{-1,-1};

        
    }
}