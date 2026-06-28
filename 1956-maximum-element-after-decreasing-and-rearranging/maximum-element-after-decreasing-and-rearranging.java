class Solution {
    //  int n=arr.length;
    //     int a=1;
    //     int d=1;
    //     int ath=1+(n-1)*d; // This would work if cond would be abs(x)==1
    //     return ath;
        
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) 
    {
        int n=arr.length;
        Arrays.sort(arr);
        arr[0]=1; //Needed;
        int prev=1;
        for(int i=1;i<n;i++)
        {
            if(arr[i]-arr[i-1]<=1) continue;
            arr[i]=(arr[i-1]+1);
        }

        return arr[n-1];
    }
}