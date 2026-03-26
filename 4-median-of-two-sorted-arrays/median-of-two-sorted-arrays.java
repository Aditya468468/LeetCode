
class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) 
    {
        int n=arr1.length;
        int m=arr2.length;
        int i=0;
        int j=0;
        ArrayList<Integer> list=new ArrayList<>();
        while(i<n && j<m)
        {
            if(arr1[i]==arr2[j])
            {
                list.add(arr1[i]);
                i++;
            }
            else if(arr1[i]>arr2[j])
            {
                list.add(arr2[j]);
                j++;
            }
            else{
                list.add(arr1[i]);
                i++;
            }
        }
        while(i<n)
        {
            list.add(arr1[i]);
            i++;
        }
        while(j<m)
        {
            list.add(arr2[j]);
            j++;
        }
        int size=list.size();
        if(size%2==0)
        {
            int idx=size/2;
            double median=list.get(idx)+list.get(idx-1);
            return median/2;
        }
        else 
        {
            int idx=size/2;
            double median=list.get(idx);
            return median;
        }
     
    }
}
