
class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) 
    {
        int n=arr1.length;
        int m=arr2.length;
        if(n>m) return findMedianSortedArrays(arr2,arr1);
        // First Array is Always the smaller
        int low=0;
        int high=n;
        int left=(n+m+1)/2;
        while(low<=high)
        {
            int mid1=low+(high-low)/2;
            int mid2=left-mid1;
            int l1=Integer.MIN_VALUE, l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE, r2=Integer.MAX_VALUE;
            if(mid1<n) r1=arr1[mid1];
            if(mid2<m) r2=arr2[mid2];
            if(mid1-1>=0) l1=arr1[mid1-1];
            if(mid2-1>=0) l2=arr2[mid2-1];
            if(l1<=r2 && l2<=r1)
            {
                if((n+m)%2==1) return Math.max(l1,l2);
                else 
                {
                return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
            }
            else if(l1>r2) high=mid1-1;
            else low=mid1+1;


        }

        return 0;
      
    }
}


