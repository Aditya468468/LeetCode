
class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) 
    {
        int n=arr1.length;
        int m=arr2.length;
        int i=0;
        int j=0;
        int size=n+m;
        int idx1=size/2;
        int idx2=idx1-1;
        int val1=0,val2=0;
        int cnt=0;
    
        while(i<n && j<m)
        {
            if(arr1[i]<=arr2[j])
            {
                if(idx1==cnt) val1=arr1[i];
                if(idx2==cnt) val2=arr1[i];
                cnt++;
                i++;
            }
            else if(arr1[i]>arr2[j])
            {
                if(idx1==cnt) val1=arr2[j];
                if(idx2==cnt) val2=arr2[j];
                cnt++;
                j++;
            }

        }
        while(i<n)
        {
            if(idx1==cnt) val1=arr1[i];
            if(idx2==cnt) val2=arr1[i];
            i++;
            cnt++;
        }
        while(j<m)
        {
            if(idx1==cnt) val1=arr2[j];
            if(idx2==cnt) val2=arr2[j];
            j++;
            cnt++;
        }
        if(size%2==0) return ((double)val1+val2)/2;
        else return (double)val1;
        
       
     
    }
}

