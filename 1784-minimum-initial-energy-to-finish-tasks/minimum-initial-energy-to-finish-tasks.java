class Solution 
{
    private boolean isPossible(int[][]tasks,long k)
    {
        long left=k;
        for(int i=0;i<tasks.length;i++)
        {
            if(left<tasks[i][1]) return false;
            if(left>=tasks[i][0])
            {
                left-=tasks[i][0];
            }
            else
            {
                return false;
            }

        }
        return true;
    }
    public int minimumEffort(int[][] tasks) 
    {
        Arrays.sort(tasks,(a,b)->
        {
            return Integer.compare(b[1]-b[0],a[1]-a[0]);
        });
        
        long low=tasks[0][1]; //Noww as its max req->I make sure all tasks starts;
        long sum=0;
        for(int i=0;i<tasks.length;i++)
        {
            sum+=tasks[i][1];
        }
        long high=sum;
        while(low<=high)
        {
            long mid=low+(high-low)/2;
            if(isPossible(tasks,mid))
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }

        return (int)low;

        
    }
}