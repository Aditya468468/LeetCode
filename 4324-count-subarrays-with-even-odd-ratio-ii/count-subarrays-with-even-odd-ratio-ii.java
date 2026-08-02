class Solution 
{
    private long mergeSort(long[]prefix,int left,int right)
    {
        if(left>=right)
        {
            return 0;
        }
        int mid=left+(right-left)/2;
        long count=0;
        count+=mergeSort(prefix,left,mid);
        count+=mergeSort(prefix,mid+1,right);

        int p=left;
        for(int j=mid+1;j<=right;j++)
            {
                while(p<=mid && prefix[p]<prefix[j])
                    {
                        p++;
                    }
                count+=(mid-p+1);
            }
        long[]temp=new long[right-left+1];
        int i=left;
        int j=mid+1;
        int idx=0;

        while(i<=mid && j<=right)
            {
                if(prefix[i]<=prefix[j])
                {
                    temp[idx]=prefix[i];
                    i++;
                }
                else
                {
                    temp[idx]=prefix[j];
                    j++;
                }
                idx++;
            }
        while(i<=mid)
            {
                temp[idx]=prefix[i];
                i++;
                idx++;
                
            }
        while(j<=right)
            {
                
                temp[idx]=prefix[j];
                j++;
                idx++;
            }
        for(int k=0;k<temp.length;k++)
            {
                prefix[left+k]=temp[k];
            }

        return count;
    }
    public long countRatioSubarrays(int[] nums, int a, int b) 
    {

        //y>0 fine,
        // x/y <=a/b --> x*b<=a*y --> smells like sliding wind, ineq.\

        int n=nums.length;
        long []prefix= new long[n+1];
        for(int i=0;i<n;i++)
            {
                if(nums[i]%2==0)
                {
                    prefix[i+1]=prefix[i]+b;
                }
                else
                {
                    prefix[i+1]=prefix[i]-a;
                }
            }
        
        return mergeSort(prefix,0,n);
        
    }
}