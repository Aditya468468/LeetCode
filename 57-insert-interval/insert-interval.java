class Solution 
{
    public int insertPosition(int[][] intervals, int pos)
    {
        int low=0;
        int high=intervals.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(intervals[mid][0]<=pos)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }

        return low;
    }
    public int[][] insert(int[][] Intervals, int[] newInterval) 
    {

        int pos=insertPosition(Intervals,newInterval[0]);
        ArrayList<int[]> intervalsList=new ArrayList<>();
        for(int []x:Intervals)
        {
            intervalsList.add(x);
        }
       
        intervalsList.add(pos,newInterval);
        int n=intervalsList.size();
        //Apply Merge Intervals
        ArrayList<int[]> list=new ArrayList<>();
        list.add(intervalsList.get(0));

        for(int i=1;i<n;i++)
        {
            int []prevInterval=list.get(list.size()-1);
            if(prevInterval[1]>=intervalsList.get(i)[0])
            {
                prevInterval[1]=Math.max(intervalsList.get(i)[1],prevInterval[1]);
            }
            else
            {
                list.add(intervalsList.get(i));
            }

        }

        int[][] ans=new int[list.size()][2];
        int idx=0;
        for(int[] x:list)
        {
            ans[idx++]=x;
        }

        return ans;

        
    }
}