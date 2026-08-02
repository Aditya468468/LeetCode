class Solution 
{
    public int findPos(long[]prefix,long k )
    {
        int n=prefix.length;
        int low=0;
        int high=n-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(prefix[mid]<=k)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }

        return high; 
    }
    public int chalkReplacer(int[] chalk, int k) 
    {
        int n=chalk.length;
        long []prefix=new long[n];
        long sum=0;

        for(int i=0;i<n;i++)
        {
            prefix[i]=sum;
            sum+=chalk[i];
        }

        long cycleDone=k/sum; //Total complete cycles which we can do.
        // After dng how much chalks are left,per cycle->totalSum will be consumed.
    
        long chalkLeft=k-((long)sum*cycleDone);

        return findPos(prefix,chalkLeft);




    }
}