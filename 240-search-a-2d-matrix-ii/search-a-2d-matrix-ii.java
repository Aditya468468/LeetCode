
class Solution {
    public boolean searchMatrix(int[][] mat, int target) 
    {
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n;i++)
        {
            if(mat[i][0]<=target && target<=mat[i][m-1])
            {
                int low=0;
                int high=m-1;
                while(low<=high)
                {
                    int mid=low+(high-low)/2;
                    if(mat[i][mid]==target)
                    {
                        return true;
                    }
                    else if(mat[i][mid]>target)
                    {
                        high=mid-1;
                    }
                    else{
                        low=mid+1;
                    }
                }
            }
        }
        return false;

    }
}
